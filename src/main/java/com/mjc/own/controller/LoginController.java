package com.example.help.controller;


import com.example.help.common.Code;
import com.example.help.common.ReturnObject;
import com.example.help.domain.AuthInfo;
import com.example.help.domain.User;
import com.example.help.service.ShiroService;
import com.example.help.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ShiroService shiroService ;
    @Autowired
    private UserService userService ;


    @RequestMapping("/signUp")
    public ReturnObject signUp(@Valid User user, HttpSession session) {

        ReturnObject returnObject = new ReturnObject();

        //当前用户不存在
        List<User> list = userService.selectAll();
         int x = 0 ;
         for (User u : list){
             if(u.getStuId().equals(user.getStuId())){
                 x = 1 ;
             }
         }
        if(x==0){
            returnObject.setCode(Code.FAIL);
            returnObject.setMsg("用户信息不存在");
            return returnObject ;
        }

        //主体,当前状态为没有认证的状态“未认证”
        Subject subject = SecurityUtils.getSubject();
        // 登录后存放进shiro token

            UsernamePasswordToken token = new UsernamePasswordToken(user.getStuId(), user.getUserPassword());
            //登录方法（认证是否通过）
            //使用subject调用securityManager,安全管理器调用Realm

            //利用异常操作
            //需要开始调用到Realm中
            System.out.println("========================================");
            System.out.println("1、进入认证方法");
            try {
                subject.login(token);
            }catch (Exception e){
                returnObject.setMsg("密码错误");
                returnObject.setCode(Code.FAIL);
                return returnObject;
            }

            user = (User) subject.getPrincipal();
            //将用户放入session中
            session.setAttribute("userId", user.getStuId());
            //将权限放入redis
            stringRedisTemplate.opsForValue().set("CURRENT_USER", user.getStuId());
            shiroService.putAuth2Redis(subject,user);
            returnObject.setCode(Code.SUCCESS);
            returnObject.setMsg("用户：" + user.getStuId() + "---登录成功");

            System.out.println("登录完成");


        return returnObject;

    }


    /**
     * 使用ajax 做页面权限控制。话说我一个人前端后台 为毛要搞前后端分离 来坑自己呢
     *
     */
    @RequestMapping(value = "queryAuth")
    public ReturnObject queryAuth(HttpServletRequest request) {
        ReturnObject returnObject =new ReturnObject();
        returnObject.setCode(Code.SUCCESS);

         //用户登入之后会将 stuId 放入session中
         returnObject.setRows(stringRedisTemplate.opsForHash().get("AUTH",request.getSession().getAttribute("userId")));


        return returnObject;
    }
    @RequestMapping(value = "quit")
    public ReturnObject quit(HttpServletRequest request ,HttpSession session) {
        ReturnObject returnObject =new ReturnObject();
        returnObject.setCode(Code.SUCCESS);


        //用户退出之后会将 stuId 从session中移除
        session.removeAttribute("userId");
        stringRedisTemplate.delete("AUTH");
        stringRedisTemplate.delete("CURRENT_USER");
        return returnObject;
    }


}
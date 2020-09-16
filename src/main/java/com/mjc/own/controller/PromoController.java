package com.mjc.own.controller;


import com.mjc.own.common.Code;
import com.mjc.own.common.ReturnObject;
import com.mjc.own.domain.Promo;
import com.mjc.own.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/promo")
public class PromoController {

    @Autowired
    public PromoService promoService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/send")
    public ReturnObject<Promo> insertPromo(Promo promo) throws  Exception{
        ReturnObject<Promo> promoReturnObject = new ReturnObject<Promo>();
        promo.setStuId(stringRedisTemplate.opsForValue().get("CURRENT_USER"));

        promoService.insert(promo);
        return promoReturnObject;
    }
    @RequestMapping("/delete")
    public ReturnObject<Promo> deletePromo(String id,String stuId) throws  Exception{
        ReturnObject<Promo> promoReturnObject = new ReturnObject<Promo>();
        promoReturnObject.setCode(Code.SUCCESS);
        //如果不是本人的学号的话 则提示非本人不可删除
        String current = stringRedisTemplate.opsForValue().get("CURRENT_USER");
        if(null != current && !"".equals(current)){

            //如果是超管登入的话
            if("123456".equals(current)){
                promoService.delete(id);
                promoReturnObject.setMsg("删除成功！！！");
            }else {
                if(!current.equals(stuId)){
                    promoReturnObject.setMsg("非本人 活动 不可删除");
                }else {
                    promoService.delete(id);
                    promoReturnObject.setMsg("删除成功！！！");
                }

            }
        }else{
            promoReturnObject.setMsg("缓存出错！！！");
        }

        return promoReturnObject;
    }

    @RequestMapping("/list")
    public ReturnObject<List<Promo>> showPromo(Promo promo) throws  Exception{
        ReturnObject<List<Promo>> promoReturnObject = new ReturnObject<List<Promo>>();

        List<Promo> promos=promoService.select(promo);
        promoReturnObject.setCode(Code.SUCCESS);
        promoReturnObject.setRows(promos);
        promoReturnObject.setMsg("查看公告");
        return promoReturnObject;
    }


}

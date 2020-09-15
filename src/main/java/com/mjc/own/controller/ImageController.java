package com.example.help.controller;

import com.example.help.common.Code;
import com.example.help.common.ReturnObject;
import com.example.help.domain.Knowledge;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by gcb on 2019/3/18.
 */
@RestController
public class ImageController {

    @RequestMapping("/uploads")
    public ReturnObject uploads(HttpServletRequest request) throws Exception {
        System.out.println("图片上传");
        ReturnObject<Knowledge> returnObject = new ReturnObject<Knowledge>();

        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            //这里经常出错 要看springMvc 是否配置正确
            MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
            Iterator<String> filenames = mreq.getFileNames();
            while (filenames.hasNext()) {
                MultipartFile file = mreq.getFile((filenames.next()));
                if (null != file) {
                    String myFileName = file.getOriginalFilename();
                    System.out.println("我的文件名" + myFileName);

                    //将文件名 做时间，后缀名 处理
                    if (!"".equals(myFileName.trim())) {

                        //文件名
                        String baseName = myFileName.substring(0, myFileName.lastIndexOf("."));
                        //后缀名
                        String extName = myFileName.substring(myFileName.lastIndexOf(".") + 1).toLowerCase();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                        String days = sdf.format(new Date());
                        String finalFileName =baseName+ days + new Random().nextInt(1000) + "." + extName;


                        //这种方式适合在 独立tomcat 容器中使用。 springBoot 中启动的是临时容器。
                       // String url = request.getSession().getServletContext().getRealPath("/upload");
                        // 这个方式 将图片上传到target 中，如果 重新bulid 之后就不行了
                        // String path  =  ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/upload/";

                        //所以我将文件直接 放在E盘下的 upload 写死
                        String url = "E:"+"\\upload";

                        File localFile = new File(url);
                        //如果文件夹不存在则 自动创建一个
                        if (!localFile.exists()) {
                            localFile.mkdirs();
                        }


                        // 文件发送到指定文件夹
                       // file.transferTo(localFile);
                       // file.transferTo(new File(url+"/" +finalFileName));
                    //    file.transferTo(new File("/upload/"+finalFileName));
                        file.transferTo(new File(url+"/" +finalFileName));
                        //将图片 回显 http://localhost:8080/upload/
                        returnObject.setCode(Code.SUCCESS);
                        //这个image 我配置的虚目录 ，默认链接到E：\\upload
                        returnObject.setMsg("/image/"+finalFileName);

                        return returnObject;

                    }


                }


            }


        }


        return null;
    }



}

package com.example.controller;

import com.example.utils.VerifyCodeUtils;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
@CrossOrigin//允许跨域
@RequestMapping("user")
public class UserController {
    /*
    * 生成验证码图片
    * */
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码
        String code= VerifyCodeUtils.generateVerifyCode(4);
//        2.将验证码放入servlet
//        3.将图片转为base64
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120, 30, byteArrayOutputStream, code);
        return "data:image/png;base64,"+Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());
    }
}

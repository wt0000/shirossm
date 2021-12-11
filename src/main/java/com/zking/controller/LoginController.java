package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        int code=1;
        String message="";
        Map<String,Object> map=new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(
                user.getUsername(), user.getPassword()
        );
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            code=-1;
            message="账号错误";
        } catch (IncorrectCredentialsException e) {
            code=0;
            message="密码错误";
        }
        map.put("code",code);
        map.put("message",message);
        session.setAttribute("map",map);
        if(code<1){
            return "login";
        }else{
            return "main";
        }
    }
}

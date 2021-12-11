package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("userList")
    @RequiresRoles("管理员")
    public String list(HttpSession session){
        List<User> users = userService.users();
        session.setAttribute("users",users);
        return "userList";
    }

    @RequestMapping("doEdit")
    public String editUser(User user){
        int i=-1;
        if(null!=user.getUserid()&&user.getUserid()!=0){
            i = userService.updateByPrimaryKey(user);
        }else{
            i = userService.insert(user);
        }
        if(i>0){
            return "redirect:userList";
        }else{
            return "goEdit";
        }
    }
    @RequestMapping("/deluser")
    public String deluser(Integer userId){
        int i = userService.deleteByPrimaryKey(userId);
        return "redirect:userList";
    }
}

package com.zking.service;

import com.zking.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional
public interface IUserService {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    //根据用户输入的账号查询用户的个人信息
    public User selByUserName(String username);
    //当用户登陆的时候，根据用户名获取到该用户的角色信息
    public Set<String> selReloByUserName(String username);
    //当用户登陆的时候，根据用户名获取到该用户的权限信息
    public Set<String> selPermissionByUserName(String username);
    //查询用户信息
    List<User> users();

}
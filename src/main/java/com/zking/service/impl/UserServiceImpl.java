package com.zking.service.impl;

import com.zking.mapper.UserMapper;
import com.zking.model.User;
import com.zking.service.IUserService;
import com.zking.util.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Integer userid) {
        return userMapper.deleteByPrimaryKey(userid);
    }

    @Override
    public int insert(User record) {
        //创建盐
        String salt = PasswordHelper.createSalt();
        //加密后的密码
        String password = PasswordHelper.createCredentials(record.getPassword(), salt);
        record.setPassword(password);
        record.setSalt(salt);
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer userid) {
        return userMapper.selectByPrimaryKey(userid);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selByUserName(String username) {
        return userMapper.selByUserName(username);
    }

    @Override
    public Set<String> selReloByUserName(String username) {
        return userMapper.selReloByUserName(username);
    }

    @Override
    public Set<String> selPermissionByUserName(String username) {
        return userMapper.selPermissionByUserName(username);
    }

    @Override
    public List<User> users() {
        return userMapper.users();
    }
}

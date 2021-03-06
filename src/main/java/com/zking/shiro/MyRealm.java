package com.zking.shiro;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
    //权限角色验证
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> roles = userService.selReloByUserName(username);
        Set<String> permissions = userService.selPermissionByUserName(username);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //设置用户角色信息
        info.setRoles(roles);
        //设置用户权限信息
        info.setStringPermissions(permissions);
        return info;
    }
    //用户身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取到前端用户输入的账号
        String username = authenticationToken.getPrincipal().toString();
        //根据账号得到用户个人信息
        User user = userService.selByUserName(username);
        if(null!=user){
            SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                    user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName()
            );
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

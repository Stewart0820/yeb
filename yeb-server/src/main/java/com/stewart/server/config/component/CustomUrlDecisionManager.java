package com.stewart.server.config.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;


/**
 *
 * 权限控制
 * 判断用户角色
 *
 * @author Stewart
 * @create 2021/11/23
 */
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : configAttributes) {
            //获取当前url所需要的角色
            String neeRole = configAttribute.getAttribute();
            //判断角色是否登录即可访问的角色，此角色再CustomFilter中设置
            if (neeRole.equals("ROLE_LOGIN")){
                //判断是否登录
                if(authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录");
                }else{
                    return;
                }
            }

            //判断用户角色是否为url需要的角色
            //authentication.getAuthorities()获取用户对应的角色[]
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals(neeRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}

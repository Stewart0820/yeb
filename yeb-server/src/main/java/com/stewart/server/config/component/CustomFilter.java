package com.stewart.server.config.component;

import com.stewart.server.pojo.Menu;
import com.stewart.server.pojo.Role;
import com.stewart.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 每个接口都会走这里，中间层
 * 权限控制
 * 根据url分析请求所需要的角色
 *
 * @author Stewart
 * @create 2021/11/23
 */
@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {


    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();


    /**
     * 白名单的访问不会走这里
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获取所有的url
        List<Menu> menus = menuService.getMenusWithRole();
        for (Menu menu : menus) {
            // 判断请求url与菜单里面的url是否匹配
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                //根据url获取roles
                String[] str = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                // 把获取的roles存到security中
                return SecurityConfig.createList(str);
            }
        }
        // 只要登录成功，默认给的角色 ROLE_LOGIN
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}

package com.stewart.server.common.utils;

import com.stewart.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 操作员工具类
 * @author Stewart
 * @create 2021/11/26
 */
public class AdminUtils {

    /**
     * 获取当前登录的操作员
     *
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

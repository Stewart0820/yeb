package com.stewart.server.service;

import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登陆之后返回token
     * @param username
     * @param password
     * @return
     */
    R login(String username, String password);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUsername(String username);
}

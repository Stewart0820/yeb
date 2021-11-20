package com.stewart.server.service.impl;

import com.stewart.server.pojo.Admin;
import com.stewart.server.mapper.AdminMapper;
import com.stewart.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}

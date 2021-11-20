package com.stewart.server.service.impl;

import com.stewart.server.pojo.Department;
import com.stewart.server.mapper.DepartmentMapper;
import com.stewart.server.service.IDepartmentService;
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
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}

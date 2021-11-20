package com.stewart.server.service.impl;

import com.stewart.server.pojo.Salary;
import com.stewart.server.mapper.SalaryMapper;
import com.stewart.server.service.ISalaryService;
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
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

}

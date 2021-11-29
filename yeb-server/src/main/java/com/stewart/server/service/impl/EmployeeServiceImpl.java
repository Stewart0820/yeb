package com.stewart.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stewart.server.common.api.PageR;
import com.stewart.server.pojo.Employee;
import com.stewart.server.mapper.EmployeeMapper;
import com.stewart.server.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDataScope
     * @return
     */
    @Override
    public PageR getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDataScope) {
        //开启分页
        Page<Employee> page = new Page<>(currentPage, size);
        IPage<Employee> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDataScope);
        PageR pageR = new PageR(employeeByPage.getTotal(), employeeByPage.getRecords());
        return pageR;
    }
}

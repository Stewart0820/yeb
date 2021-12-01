package com.stewart.server.service;

import com.stewart.server.common.api.PageR;
import com.stewart.server.pojo.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工(分页)
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDataScope
     * @return
     */
    PageR getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDataScope);

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);
}

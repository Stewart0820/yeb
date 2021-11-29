package com.stewart.server.controller;


import com.stewart.server.common.api.PageR;
import com.stewart.server.pojo.Employee;
import com.stewart.server.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @ApiOperation(value = "获取所有员工(分页)")
    @GetMapping("/")
    public PageR getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                             @RequestParam(defaultValue = "10") Integer size,
                             Employee employee,
                             //这个时间有问题，查询不了
                             LocalDate[] beginDataScope){
        return employeeService.getEmployeeByPage(currentPage,size,employee,beginDataScope);
    }











}

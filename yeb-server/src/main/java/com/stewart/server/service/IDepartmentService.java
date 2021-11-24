package com.stewart.server.service;

import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param department
     * @return
     */
    R addDep(Department department);

    /**
     * 删除部门
     * @param id
     * @return
     */
    R deleteDep(Integer id);
}

package com.stewart.server.mapper;

import com.stewart.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments(Integer parentId);
    /**
     * 添加部门
     * @param department
     * @return
     */
    void addDep(Department department);

    /**
     * 删除部门
     * @param dep
     */
    void deleteDep(Department dep);
}

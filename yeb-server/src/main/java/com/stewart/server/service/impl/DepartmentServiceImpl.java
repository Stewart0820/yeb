package com.stewart.server.service.impl;

import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Department;
import com.stewart.server.mapper.DepartmentMapper;
import com.stewart.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartments(-1);
    }

    /**
     * 添加部门
     * @param department
     * @return
     */
    @Override
    public R addDep(Department department) {
        department.setEnabled(true);
        departmentMapper.addDep(department);
        if (department.getResult()==1){
            return R.success("添加成功",department);
        }
        return R.error("添加失败");
    }
    /**
     * 删除部门
     * @param id
     * @return
     */
    @Override
    public R deleteDep(Integer id) {
        Department dep = new Department();
        dep.setId(id);
        departmentMapper.deleteDep(dep);
        if(dep.getResult()==-2){
            return R.error("该部门下还有子部门,删除失败");
        }
        if(dep.getResult()==-1){
            return R.error("该部门下还有员工,删除成功");
        }
        if(dep.getResult()==1){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }
}

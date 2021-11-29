package com.stewart.server.controller;


import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Admin;
import com.stewart.server.pojo.Role;
import com.stewart.server.service.IAdminService;
import com.stewart.server.service.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@RestController
@RequestMapping("/system/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @Autowired
    private IRoleService roleService;
    @ApiOperation(value = "获取所有操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmins(String keywords){
        return adminService.getAllAdmins(keywords);
    }


    @ApiOperation(value = "更新操作员")
    @PutMapping("/")
    public R updateAdmin(@RequestBody Admin admin){
        if(adminService.updateById(admin)){
            return R.success("更新成功");
        }
        return R.error("更新失败");
    }

    @ApiOperation(value = "删除操作员")
    @DeleteMapping("/{id}")
    public R deleteAdmin(@PathVariable Integer id){
        if(adminService.removeById(id)){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation(value = "更新操作员角色")
    @PutMapping("/role")
    public R updateAdminRole(Integer adminId,Integer[] rids){
        return adminService.updateAdminRole(adminId,rids);
    }
}

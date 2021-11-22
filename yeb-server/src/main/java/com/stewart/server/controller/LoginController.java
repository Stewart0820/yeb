package com.stewart.server.controller;

import com.stewart.server.common.api.R;
import com.stewart.server.params.AdminLoginParam;
import com.stewart.server.pojo.Admin;
import com.stewart.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author Stewart
 * @create 2021/11/20
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public R login(@RequestBody AdminLoginParam adminLoginParam){
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword());
    }


    @ApiOperation(value = "获取当前登陆用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        // Principal可以获取当前登陆的用户对象
        if(principal==null){
            return null;
        }

        String username = principal.getName();
        Admin admin = adminService.getAdminByUsername(username);
        admin.setPassword(null);
        return admin;

    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public R logout(){
        return R.success("注销成功");
    }
}

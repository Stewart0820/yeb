package com.stewart.server.controller;


import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Joblevel;
import com.stewart.server.service.IJoblevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取职称")
    @GetMapping("/")
    public List<Joblevel> getAllJoblevel(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public R AddJoblevel(@RequestBody Joblevel joblevel){
        if(joblevelService.save(joblevel)){
            return R.success("添加成功");
        }
        return R.error("添加失败");
    }

    @ApiOperation(value = "修改职称")
    @PutMapping("/")
    public R updateJoblevel(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)){
            return R.success("更新成功");
        }
        return R.error("更新失败");
    }

    @ApiOperation(value = "根据id删除职称")
    @DeleteMapping("/{id}")
    public R deleteJoblevel(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }

    @ApiOperation(value = "批量删除")
    @DeleteMapping("/")
    public R deleteJoblevelsByIds(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }



















}

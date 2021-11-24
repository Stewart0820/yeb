package com.stewart.server.controller;


import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Position;
import com.stewart.server.service.IPositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/system/config/pos")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    @ApiOperation(value = "获取所有的职位信息")
    @GetMapping("/")
    public List<Position> getAllPosition(){
        return positionService.list();
    }


    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public R addPosition(@RequestBody Position position){
        position.setCreateDate(LocalDateTime.now());
        if(positionService.save(position)){
            return R.success("添加成功");
        }
        return R.error("添加失败");
    }

    @ApiOperation(value = "更新职位信息")
    @PutMapping("/")
    public R updatePosition(@RequestBody Position position){
        if(positionService.updateById(position)){
            return R.success("更新成功");
        }
        return R.error("更新失败");
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public R deletePosition(@PathVariable Integer id){
        if(positionService.removeById(id)){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }



    @ApiOperation(value = "批量删除所有信息")
    @DeleteMapping("/")
    public R deletePositionByIds(Integer[] ids){
        if(positionService.removeByIds(Arrays.asList(ids))){
            return R.success("删除成功");
        }
        return R.error("删除失败");
    }


}

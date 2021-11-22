package com.stewart.server.mapper;

import com.stewart.server.pojo.Menu;
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
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);
}

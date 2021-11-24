package com.stewart.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stewart.server.common.api.R;
import com.stewart.server.pojo.Menu;
import com.stewart.server.pojo.MenuRole;
import com.stewart.server.mapper.MenuRoleMapper;
import com.stewart.server.service.IMenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;
    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public R updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        if(mids==null||mids.length==0){
            return R.success("更新成功");
        }
        Integer result = menuRoleMapper.insertRecord(rid, mids);
        if(result==mids.length){
            return R.success("更新成功");
        }
        return R.error("更新失败");
    }
}

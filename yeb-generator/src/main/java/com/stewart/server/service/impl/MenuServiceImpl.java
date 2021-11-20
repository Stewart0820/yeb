package com.stewart.server.service.impl;

import com.stewart.server.pojo.Menu;
import com.stewart.server.mapper.MenuMapper;
import com.stewart.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}

package com.stewart.server.mapper;

import com.stewart.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.stewart.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}

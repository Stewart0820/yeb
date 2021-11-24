package com.stewart.server.common.exception;

import com.stewart.server.common.api.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 *
 * @author Stewart
 * @create 2021/11/24
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public R mysqlException(SQLException e){
        if(e instanceof SQLIntegrityConstraintViolationException){
            return R.error("该数据已有关联数据,操作失败");
        }
        return R.error("数据库异常,操作失败！");
    }

}

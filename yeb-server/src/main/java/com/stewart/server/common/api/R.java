package com.stewart.server.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 公共返回对象
 * @author Stewart
 * @create 2021/11/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {

    private long code;
    private String message;
    private Object object;

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static R success(String message){
        return new R(200,message,null);
    }

    /**
     * 成功返回
     * @param message
     * @return
     */
    public static R success(String message, Object obj){
        return new R(200,message,obj);
    }


    /**
     * 失败返回
     * @param message
     * @return
     */
    public static R error(String message){
        return new R(500,message,null);
    }


    /**
     * 失败返回
     * @param message
     * @return
     */
    public static R error(String message, Object obj){
        return new R(500,message,obj);
    }
}















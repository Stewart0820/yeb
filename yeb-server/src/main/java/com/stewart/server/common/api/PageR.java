package com.stewart.server.common.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Stewart
 * @create 2021/11/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageR {

    /**
     * 总条数
     */
    private Long total;

    /**
     * 数据list
     */
    private List<?> data;
}

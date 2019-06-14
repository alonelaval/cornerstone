package com.alonelaval.cornerstone.entity.base;

import lombok.Builder;
import lombok.Data;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Data
@Builder
public class JsonResult<T> {
    private int resultCode;
    private String message;
    private T data;
    private Object extendData;
}

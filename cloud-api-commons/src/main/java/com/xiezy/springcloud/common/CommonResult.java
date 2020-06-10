package com.xiezy.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 由于前后端交互统一格式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    //结果代码。eg 200  404
    private int code;

    //处理消息
    private String message;

    //携带数据
    private T data;

    public CommonResult(int code, String message) {
        this(code, message, null);
    }
}

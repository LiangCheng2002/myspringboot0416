package com.work.lc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 响应体
 *
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    /**
     * 状态码
     *
     */
    private Integer code;

    /**
     * 响应信息
     *
     */
    private String message;

    /**
     * 返回数据
     *
     */
    T data;

    public ResponseResult(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public ResponseResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }


}

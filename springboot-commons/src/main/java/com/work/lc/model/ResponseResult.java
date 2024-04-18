package com.work.lc.model;

import com.work.lc.exception.BaseException;
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
    public ResponseResult(String message, T data){
        this.message = message;
        this.data = data;
    }

    public ResponseResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t    异常
     * @param data 返回数据
     * @param <T>  {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ResponseResult ofException(T t, Object data) {
        return new ResponseResult(t.getCode(), t.getMessage(), data);
    }

    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ResponseResult ofException(T t) {
        return ofException(t, null);
    }


}

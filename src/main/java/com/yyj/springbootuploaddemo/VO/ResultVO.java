package com.yyj.springbootuploaddemo.VO;

import lombok.Data;

@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;
}

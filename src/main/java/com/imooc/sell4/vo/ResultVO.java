package com.imooc.sell4.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 1524183372752488514L;
    /** 错误码 */
    private Integer code;
    /** 提示信息 */
    private String msg;
    /** 集体内容 */
    private T data;
}



package com.weike.weike.response;


import java.util.HashMap;

/**
 * 自定义返回结果
 * @author XieEnlong
 * @date 2015/7/14.
 */
public class ResultModel {

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String msg;

    /**
     * 返回内容
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    public Object getData() {
        return data;
    }



    public ResultModel(int code, String message) {
        this.code = code;
        this.msg = message;
        this.data = new HashMap<>();
    }

    public ResultModel(int code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public ResultModel(ResultStatus status) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        this.data = new HashMap<>();
    }

    public ResultModel(ResultStatus status, Object data) {
        this.code = status.getCode();
        this.msg = status.getMessage();
        this.data = data;
    }

    public static ResultModel ok(Object data) {
        return new ResultModel(ResultStatus.SUCCESS, data);
    }

    public static ResultModel ok() {
        return new ResultModel(ResultStatus.SUCCESS);
    }

    public static ResultModel error(ResultStatus error) {
        return new ResultModel(error);
    }
    public static ResultModel error(ResultStatus error, Object data) {
        return new ResultModel(error,data);
    }
}

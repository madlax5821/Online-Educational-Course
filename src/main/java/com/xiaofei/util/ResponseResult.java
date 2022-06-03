package com.xiaofei.util;

/**
 * Author: xiaofei
 * Date: 2022-05-29, 0:09
 * Description:
 */
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseResult success(Object data){
        ResponseResult result = new ResponseResult();
        result.setCode(0);
        result.setMsg("success");
        result.setData(data);
        result.setSuccess(true);
        return result;
    }

    public static ResponseResult success(){
        ResponseResult result = new ResponseResult();
        result.setCode(0);
        result.setMsg("success");
        result.setSuccess(true);
        return result;
    }

    public static ResponseResult fail(String errorMsg){
        ResponseResult result = new ResponseResult();
        result.setCode(400);
        result.setMsg(errorMsg);
        result.setSuccess(false);
        return result;
    }
}

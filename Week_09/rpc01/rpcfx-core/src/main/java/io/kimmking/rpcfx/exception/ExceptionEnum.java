package io.kimmking.rpcfx.exception;

public enum ExceptionEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SERVICE_NOT_FIND(-101, "方法不存在"),
    ;

    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

package com.ssy.restfuluser.exception;

import lombok.Data;

@Data
public class UnifiedException extends RuntimeException {
    private int code;
    private String msgDetail;
    private Object data;

    public UnifiedException(int code, String message) {
        super(message);
        this.code = code;
    }

    public UnifiedException(int code, String message, Object obj) {
        super(message);
        this.code = code;
        this.data = obj;
    }

    public static UnifiedException create(int code, String msg, String lineInfo) {
        UnifiedException unifiedException = new UnifiedException(code, msg);
        unifiedException.setMsgDetail(lineInfo + msg);
        return unifiedException;
    }

    public static UnifiedException create(int code, String msg, String lineInfo, Object obj) {
        UnifiedException unifiedException = new UnifiedException(code, msg, obj);
        unifiedException.setMsgDetail(lineInfo + msg);
        return unifiedException;
    }
}

package com.nextrt.zoo.vo;

import lombok.Data;

@Data
public class Result {
    private int status = -1;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
}

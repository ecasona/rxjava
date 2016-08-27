package com.ecasona.rxjavaapplication.entity;

/**
 * Created by Administrator on 2016/8/25.
 */
public class Result<T> {

    private String ret;
    private String msg;
    private T row;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRow() {
        return row;
    }

    public void setRow(T t) {
        this.row = t;
    }

    @Override
    public String toString() {
        return "Result{" +
                "ret='" + ret + '\'' +
                ", msg='" + msg + '\'' +
                ", t=" + row +
                '}';
    }
}

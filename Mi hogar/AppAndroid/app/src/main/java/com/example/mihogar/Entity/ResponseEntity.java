package com.example.mihogar.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ResponseEntity {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("msg")
    @Expose
    private String msg;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseEntity() {
    }

    /**
     *
     * @param msg
     * @param code
     * @param data
     */
    public ResponseEntity(int code, List<Object> data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

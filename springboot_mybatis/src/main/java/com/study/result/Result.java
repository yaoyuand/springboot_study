package com.study.result;

/**
 * @Author ytj
 * @Date 2021/3/18 16:26
 */
public class Result<T> {
    private String code;

    private String message;

    private T data;

    public static <T>Result<T> success(T data){

        return null;
    }

    public static <T>Result<T> success(){

        return null;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data=data;
    }

    public Result() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package com.example.fabric.pojo;

public class Result {
    private Integer code;
    private String mag;
    private Object data;

    public Result(Integer code, String mag, Object data) {
        this.code = code;
        this.mag = mag;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", mag='" + mag + '\'' +
                ", data=" + data +
                '}';
    }

    public static Result success(){
        return new Result(1,"success",null);
    }

    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    public static Result error(String mag){
        return new Result(0,mag,null);
    }
}

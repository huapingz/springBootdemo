package com.example.springbootdemo.data;

public class ResultData<T> {
    private String status;
    private String message;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultData(){
        super();
    }
    public ResultData(String status,String message,T data){
        super();
        this.status=status;
        this.message=message;
        this.data = data;
    }
    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

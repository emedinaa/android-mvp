package com.emedinaa.androidmvp.data.entity.response;

/**
 * Created by em on 22/04/16.
 */
public class BaseResponse {
    /*
        {
          "msg": "success",
          "status": 200,
          "data":{}
        }
    */
    private static final int SUCCESS=200;
    private String msg;
    private int status;


    public boolean isSuccess()
    {
        if(this.status==SUCCESS)return true;
        return false;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

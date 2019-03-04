package com.blog.website.common;

/**
 * @author jiangzehao
 * @date 2019/3/4 16:08
 */
public class APIResult {
    public static final Integer ERROR_CODE_FAIL = 100;
    public static final String ERROR_MSG_FAIL ="error";

    private int returnCode;
    private String returnMsg;

    public APIResult(int code, String msg) {
        this.returnCode = code;
        this.returnMsg = msg;
    }

    public APIResult() {
        this.returnCode = 0;
        this.returnMsg = "success";
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return this.returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public static APIResult success(String msg) {
        APIResult apiResult = new APIResult();
        apiResult.setReturnCode(0);
        apiResult.setReturnMsg(msg);
        return apiResult;
    }

    public static APIResult success() {
        return success("success");
    }

    public static APIResult error(int code, String msg) {
        APIResult apiResult = new APIResult();
        apiResult.setReturnCode(code);
        apiResult.setReturnMsg(msg);
        return apiResult;
    }
}

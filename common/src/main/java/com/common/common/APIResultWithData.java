package com.common.common;

/**
 * @author jiangzehao
 * @date 2019/3/4 16:09
 */
public class APIResultWithData extends APIResult {

    private Object data;

    public APIResultWithData() {
    }

    public APIResultWithData(int code, String msg) {
        super(code, msg);
    }

    public APIResultWithData(int code, String msg, Object data) {
        super(code, msg);
        this.setData(data);
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static APIResultWithData success(Object data) {
        APIResultWithData result = new APIResultWithData();
        result.setData(data);
        return result;
    }

}

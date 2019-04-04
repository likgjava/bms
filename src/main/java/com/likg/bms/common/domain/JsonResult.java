package com.likg.bms.common.domain;

/**
 * 用于传递AJAX请求的返回结果
 *
 * @author likaige
 * @create 2019年4月3日 上午10:03:30
 */
public class JsonResult {

    /**
     * 错误码
     */
    private int code;

    /**
     * 异常信息
     */
    private String msg;

    /**
     * 响应数据
     */
    private Object data;


    /**
     * 生成操作成功的信息
     */
    public static JsonResult getInstance() {
        JsonResult json = new JsonResult();
        json.setCode(1000);
        json.setMsg("操作成功");
        return json;
    }

    /**
     * 生成操作失败的信息
     */
    public static JsonResult getFailResult(int code, String msg) {
        JsonResult json = new JsonResult();
        json.setCode(code);
        json.setMsg(msg);
        return json;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

package fun.pullock.dcc.result;


import fun.pullock.dcc.model.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "结果信息")
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3853420960188413352L;

    @ApiModelProperty(value = "是否成功")
    private boolean success = true;

    @ApiModelProperty(value = "结果码")
    private int code;

    @ApiModelProperty(value = "结果信息")
    private String msg;

    @ApiModelProperty(value = "结果")
    private T model;

    public Result() {
    }

    public Result(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.success = false;
    }

    public Result(ErrorCode errorCode, String extMsg) {
        this.code = errorCode.getCode();
        this.msg = String.format("%s %s", errorCode.getMsg(), extMsg);
        this.success = false;
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

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
            "success=" + success +
            ", code=" + code +
            ", msg='" + msg + '\'' +
            ", model=" + model +
            '}';
    }
}

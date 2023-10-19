package fun.pullock.dcc.model;

public enum ErrorCode {

    SYSTEM_ERROR(1, "系统错误"),
    PARAM_ERROR(2, "参数错误"),

    GROUP_NOT_EXIST(100000, "组不存在"),

    ENV_NOT_EXIST(200000, "环境不存在"),

    CONFIG_EXISTED(200000, "配置已存在"),
    CONFIG_NOT_EXIST(200001, "配置不存在"),

    ZK_ERROR(300000, "Zookeeper出错")
    ;

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

package me.cxis.dcc.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "配置")
public class ConfigVO implements Serializable {

    private static final long serialVersionUID = 980055193373837391L;

    @ApiModelProperty(value = "配置所属组ID")
    private Long groupId;

    @ApiModelProperty(value = "配置所属环境ID")
    private Long envId;

    @ApiModelProperty(value = "配置类型 1-String 2-Number 3-Json 4-Boolean")
    private Integer type;

    @ApiModelProperty(value = "配置的key")
    private String key;

    @ApiModelProperty(value = "配置的描述")
    private String desc;

    @ApiModelProperty(value = "配置的值")
    private String value;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigVO{" +
            "groupId=" + groupId +
            ", envId=" + envId +
            ", type=" + type +
            ", key='" + key + '\'' +
            ", desc='" + desc + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}

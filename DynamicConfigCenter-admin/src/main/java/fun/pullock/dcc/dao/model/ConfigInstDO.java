package fun.pullock.dcc.dao.model;

import java.util.Date;

public class ConfigInstDO {

    private Long id;

    private Date createdTime;

    private Date modifiedTime;

    private Integer version;

    private Long configId;

    private Long envId;

    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getConfigId() {
        return configId;
    }

    public void setConfigId(Long configId) {
        this.configId = configId;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ConfigInstDO{" +
            "id=" + id +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", version=" + version +
            ", configId=" + configId +
            ", envId=" + envId +
            ", value='" + value + '\'' +
            '}';
    }
}
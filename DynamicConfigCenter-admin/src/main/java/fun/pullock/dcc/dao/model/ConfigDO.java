package fun.pullock.dcc.dao.model;

import java.util.Date;

public class ConfigDO {

    private Long id;

    private Date createdTime;

    private Date modifiedTime;

    private Integer version;

    private String key;

    private Integer type;

    private String desc;

    private Long groupId;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "ConfigDO{" +
            "id=" + id +
            ", createdTime=" + createdTime +
            ", modifiedTime=" + modifiedTime +
            ", version=" + version +
            ", key='" + key + '\'' +
            ", type=" + type +
            ", desc='" + desc + '\'' +
            ", groupId=" + groupId +
            '}';
    }
}
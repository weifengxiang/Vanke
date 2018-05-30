package org.sky.base.model;

import java.util.Date;

public class BaseParttimeJobEnroll {
    private String id;

    private String jobCode;

    private String code;

    private String chaCode;
    
    private Date enrollDate;

    private String state;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;
    
    private String chaCodeName;
    
    private String chaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChaCode() {
        return chaCode;
    }

    public void setChaCode(String chaCode) {
        this.chaCode = chaCode;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getChaCodeName() {
		return chaCodeName;
	}

	public void setChaCodeName(String chaCodeName) {
		this.chaCodeName = chaCodeName;
	}

	public String getChaId() {
		return chaId;
	}

	public void setChaId(String chaId) {
		this.chaId = chaId;
	}
}
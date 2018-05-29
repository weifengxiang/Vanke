package org.sky.base.model;

import java.math.BigDecimal;
import java.util.Date;

public class BaseWithdrawCash {
    private String id;

    private String chaCode;

    private String bankCode;

    private String cardCode;

    private BigDecimal amount;

    private Date reqDate;

    private String state;

    private String note;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChaCode() {
        return chaCode;
    }

    public void setChaCode(String chaCode) {
        this.chaCode = chaCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
}
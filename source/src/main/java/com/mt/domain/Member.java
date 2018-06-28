package com.mt.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Member implements IEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 上级ID
     */
    private Integer parentId;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 冻结金额(提现中)
     */
    private Double freez;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 类型:1-月度用户, 2-季度用户,3-月度用户
     */
    private int type;

    /**
     * 
     */
    private Date createDate;

    /**
     * 状态:0-无效, 1-有效
     */
    private int status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getFreez() {
        return freez;
    }

    public void setFreez(Double freez) {
        this.freez = freez;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
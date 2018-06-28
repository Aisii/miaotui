package com.mt.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Advertisement implements IEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 类型: 1-顶部, 2-文中, 3-文尾
     */
    private Integer type;

    /**
     * 
     */
    private String url;

    /**
     * 
     */
    private Date createDate;

    /**
     * 0-用户删除, 1-平台删除, 2-有效
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
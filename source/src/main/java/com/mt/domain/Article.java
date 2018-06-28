package com.mt.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Article implements IEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 会员ID
     */
    private Integer memberId;

    /**
     * 标题
     */
    private String title;

    /**
     * 点赞数
     */
    private Integer zan;

    /**
     * 
     */
    private Date createDate;

    /**
     * 状态:0-岗位, 1-有效
     */
    private Integer status;

    /**
     * 内容
     */
    private String content;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
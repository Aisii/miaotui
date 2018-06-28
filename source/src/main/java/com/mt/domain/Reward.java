package com.mt.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Reward implements IEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer meberId;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private Double amount;

    /**
     * 
     */
    private Date createDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMeberId() {
        return meberId;
    }

    public void setMeberId(Integer meberId) {
        this.meberId = meberId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
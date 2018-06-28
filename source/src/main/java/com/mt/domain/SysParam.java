package com.mt.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class SysParam implements IEntity {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String sysKey;

    /**
     * 
     */
    private String sysValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysKey() {
        return sysKey;
    }

    public void setSysKey(String sysKey) {
        this.sysKey = sysKey == null ? null : sysKey.trim();
    }

    public String getSysValue() {
        return sysValue;
    }

    public void setSysValue(String sysValue) {
        this.sysValue = sysValue == null ? null : sysValue.trim();
    }
}
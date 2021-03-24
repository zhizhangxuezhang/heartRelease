package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Collections)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:02
 */
public class Collections implements Serializable {
    private static final long serialVersionUID = 478520833013699271L;
    
    private Integer id;
    
    private Integer userId;
    
    private Integer masterId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

}
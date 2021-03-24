package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (PersonalLabel)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:07
 */
public class PersonalLabel implements Serializable {
    private static final long serialVersionUID = -72107877969413678L;
    
    private Integer id;
    
    private String name;
    
    private Integer masterId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

}
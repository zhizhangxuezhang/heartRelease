package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Mood)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:04
 */
public class Mood implements Serializable {
    private static final long serialVersionUID = -56716633073043513L;
    
    private Integer id;
    
    private String content;
    
    private String picture;
    
    private Object isAnonymous;
    
    private String publishTime;
    
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Object getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Object isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:03
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -30578804734109071L;
    
    private Integer id;
    
    private String text;
    
    private Integer userId;
    
    private String commentTime;
    
    private Integer moodId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

}
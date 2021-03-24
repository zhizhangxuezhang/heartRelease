package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (ThumbUp)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:08
 */
public class ThumbUp implements Serializable {
    private static final long serialVersionUID = -74937818809874511L;
    
    private Integer id;
    
    private String thumbsUpTime;
    
    private Integer userId;
    
    private Integer moodId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThumbsUpTime() {
        return thumbsUpTime;
    }

    public void setThumbsUpTime(String thumbsUpTime) {
        this.thumbsUpTime = thumbsUpTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMoodId() {
        return moodId;
    }

    public void setMoodId(Integer moodId) {
        this.moodId = moodId;
    }

}
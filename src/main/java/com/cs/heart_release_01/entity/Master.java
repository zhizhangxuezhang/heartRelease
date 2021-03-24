package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Master)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:04
 */
public class Master implements Serializable {
    private static final long serialVersionUID = 721295658400767421L;
    
    private Integer id;
    
    private String username;
    
    private Object sex;
    
    private String birthday;
    
    private String briefIntroduction;
    
    private Integer dayCount;
    
    private Integer objectCount;
    
    private Integer orderCount;
    
    private String openId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(Integer objectCount) {
        this.objectCount = objectCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "Master{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthday='" + birthday + '\'' +
                ", briefIntroduction='" + briefIntroduction + '\'' +
                ", dayCount=" + dayCount +
                ", objectCount=" + objectCount +
                ", orderCount=" + orderCount +
                ", openId='" + openId + '\'' +
                '}';
    }
}
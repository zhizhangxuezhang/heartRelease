package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Cord)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:03
 */
public class Cord implements Serializable {
    private static final long serialVersionUID = 842838987006911783L;
    
    private Integer id;
    
    private String time;
    
    private Object grade;
    
    private String text;
    
    private Integer userId;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getGrade() {
        return grade;
    }

    public void setGrade(Object grade) {
        this.grade = grade;
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

}
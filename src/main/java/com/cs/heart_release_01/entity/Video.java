package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Video)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:09
 */
public class Video implements Serializable {
    private static final long serialVersionUID = -22026683133880295L;
    
    private Integer id;
    
    private String mpFourUrl;
    
    private String text;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMpFourUrl() {
        return mpFourUrl;
    }

    public void setMpFourUrl(String mpFourUrl) {
        this.mpFourUrl = mpFourUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
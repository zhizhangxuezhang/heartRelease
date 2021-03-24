package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Music)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:05
 */
public class Music implements Serializable {
    private static final long serialVersionUID = 460299106506296514L;
    
    private Integer id;
    
    private String mpThreeUrl;
    
    private String author;
    
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMpThreeUrl() {
        return mpThreeUrl;
    }

    public void setMpThreeUrl(String mpThreeUrl) {
        this.mpThreeUrl = mpThreeUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
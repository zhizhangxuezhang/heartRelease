package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Photo)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:07
 */
public class Photo implements Serializable {
    private static final long serialVersionUID = -78828328030265454L;
    
    private Integer id;
    
    private String cardZ;
    
    private String cardF;
    
    private String proveBook;
    
    private Integer masterId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardZ() {
        return cardZ;
    }

    public void setCardZ(String cardZ) {
        this.cardZ = cardZ;
    }

    public String getCardF() {
        return cardF;
    }

    public void setCardF(String cardF) {
        this.cardF = cardF;
    }

    public String getProveBook() {
        return proveBook;
    }

    public void setProveBook(String proveBook) {
        this.proveBook = proveBook;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

}
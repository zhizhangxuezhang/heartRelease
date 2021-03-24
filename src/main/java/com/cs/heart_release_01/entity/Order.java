package com.cs.heart_release_01.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-02-04 16:49:06
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -69810534586019175L;
    
    private Integer id;
    
    private String appointmentTime;
    
    private Object payMoney;
    
    private String consultWay;
    
    private String appointmentPlace;
    
    private Integer orderState;
    
    private String time;
    
    private Integer masterId;
    
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Object getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Object payMoney) {
        this.payMoney = payMoney;
    }

    public String getConsultWay() {
        return consultWay;
    }

    public void setConsultWay(String consultWay) {
        this.consultWay = consultWay;
    }

    public String getAppointmentPlace() {
        return appointmentPlace;
    }

    public void setAppointmentPlace(String appointmentPlace) {
        this.appointmentPlace = appointmentPlace;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
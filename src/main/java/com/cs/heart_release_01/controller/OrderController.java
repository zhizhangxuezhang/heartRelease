package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.entity.Order;
import com.cs.heart_release_01.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("order")
@Api(tags = {"订单"})
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;


    //用户创建订单，预约状态是申请状态0
    @PostMapping("createOne")
    @ApiOperation(value = "用户创建一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "appointment_time", dataType = "String", required = true, value = "预约时间"),
            @ApiImplicitParam(paramType = "query", name = "pay_money", dataType = "double", required = true, value = "支付金额"),
            @ApiImplicitParam(paramType = "query", name = "consult_way", dataType = "String", required = true, value = "咨询方式"),
            @ApiImplicitParam(paramType = "query", name = "appointment_place", dataType = "String", required = true, value = "咨询地点"),
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id"),
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id")
    })
    public Order createOne(String appointment_time,Double pay_money,String consult_way,String appointment_place,Integer master_id,Integer user_id){
        Order order = new Order();
        order.setAppointmentTime(appointment_time);
        order.setPayMoney(pay_money);
        order.setConsultWay(consult_way);
        order.setAppointmentPlace(appointment_place);
        order.setOrderState(0);
        order.setMasterId(master_id);
        order.setUserId(user_id);
        //创建当前的时间并格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);

        order.setTime(format);
        Order insert = orderService.insert(order);
        return insert;
    }
    //咨询师同意，则为未完成状态 1
    @PutMapping("updateOne")
    @ApiOperation(value = "咨询师同意")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "订单id")
    })
    public Order updateOne(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderState(1);
        Order update = orderService.update(order);
        return update;

    }
    //超过这个时间，为完成状态 2
    @PutMapping("updateOne_2")
    @ApiOperation(value = "预约时间超时状态")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "订单id")
    })
    public Order updateOne_2(Integer id) throws ParseException {
        //获取当前的时间
        Date date = new Date();
        //根据id获取数据库中对应对象的预约时间
        String appointmentTime = orderService.queryById(id).getAppointmentTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date format = sdf.parse(appointmentTime);
        //比较这两个时间
        if(date.getTime()>format.getTime()){
            //超时 改为完成状态
            Order order = new Order();
            order.setId(id);
            order.setOrderState(2);
            Order update = orderService.update(order);
            return update;
        }else {
            return orderService.queryById(id);
        }
    }
    //用户取消，为失败订单-1
    @PutMapping("updateOne_3")
    @ApiOperation(value = "用户取消一个订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "订单id")
    })
    public Order updateOne_3(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderState(-1);
        Order update = orderService.update(order);
        return update;
    }
    //咨询师不同意，为失败订单-2
    @PutMapping("updateOne_4")
    @ApiOperation(value = "咨询师不同意一个订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "订单id")
    })
    public Order updateOne_4(Integer id){
        Order order = new Order();
        order.setId(id);
        order.setOrderState(-2);
        Order update = orderService.update(order);
        return update;
    }
    //显示用户自己的订单
    @GetMapping("selectByUserId")
    @ApiOperation(value = "显示用户自己的所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id")
    })
    public List<Order> selectByUserId(Integer user_id){
        Order order = new Order();
        order.setUserId(user_id);
        List<Order> orders = orderService.queryAll(order);
        return orders;
    }
    //显示咨询师的订单
    @GetMapping("selectByMasterId")
    @ApiOperation(value = "显示咨询师自己的所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id")
    })
    public List<Order> selectByMasterId(Integer master_id){
        Order order = new Order();
        order.setMasterId(master_id);
        List<Order> orders = orderService.queryAll(order);
        return orders;
    }
    //预约提醒
    //状态为1，传入master的id
    @GetMapping("selectForDate")
    @ApiOperation(value = "预约提醒")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id")
    })
    public List<String> selectForDate(Integer master_id){
        //根据咨询师的id查找该咨询师的所有订单（只包含同意且为未完成，即状态为1的）
        Order order = new Order();
        order.setMasterId(master_id);
        order.setOrderState(1);
        //获取到结果集
        List<Order> orders = orderService.queryAll(order);
        //创建集合存储时间
        List<String> appointmentTimes = new ArrayList<>();
        for(Order order1:orders){
            appointmentTimes.add(order1.getAppointmentTime());
        }
        return appointmentTimes;
    }
}
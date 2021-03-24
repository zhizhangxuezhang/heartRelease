package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.entity.User;
import com.cs.heart_release_01.service.MasterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Master)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:26
 */
@RestController
@RequestMapping("master")
@Api(tags = {"咨询师"})
public class MasterController {
    /**
     * 服务对象
     */
    @Resource
    private MasterService masterService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @GetMapping("selectOne")
    @ApiOperation(value = "根据id查询一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "Integer", required = true, value = "咨询师id")
    })
    public Master selectOne(Integer id) {
        return this.masterService.queryById(id);
    }

    @ApiOperation(value = "更新一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "咨询师id"),
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value = "名字"),
            @ApiImplicitParam(paramType = "query", name = "sex", dataType = "boolean", required = true, value = "性别<男t女f>"),
            @ApiImplicitParam(paramType = "query", name = "birthday", dataType = "String", required = true, value = "生日"),
            @ApiImplicitParam(paramType = "query", name = "brief_introduction", dataType = "String", required = true, value = "简介"),
            @ApiImplicitParam(paramType = "query", name = "day_count", dataType = "int", required = true, value = "成为咨询师的天数"),
            @ApiImplicitParam(paramType = "query", name = "object_count", dataType = "int", required = true, value = "服务对象个数"),
            @ApiImplicitParam(paramType = "query", name = "order_count", dataType = "int", required = true, value = "成功订单个数")
    })
    //更新自己的资料
    @PutMapping("updateOne")
    public Master updateOne(Integer id, String username, boolean sex, String birthday, String brief_introduction, Integer day_count, Integer object_count, Integer order_count){

        Master master = new Master();
        master.setId(id);
        master.setUsername(username);
        master.setSex(sex);
        master.setBirthday(birthday);
        master.setBriefIntroduction(brief_introduction);
        master.setDayCount(day_count);
        master.setObjectCount(object_count);
        master.setOrderCount(order_count);
        Master master1 = masterService.update(master);

        return master1;
    }

    //显示最新入驻的咨询师(只需要显示一个)
    @GetMapping("selectNewest")
    @ApiOperation(value = "显示最新入驻的一个")
    public Master selectNewest(){
        Master master = masterService.queryNewest();
        return master;
    }
   /*
   * 显示推荐的咨询师
   * 因为不知推荐机制是什么，所以暂时写成推荐所有的咨询师
   *
   * */
   @GetMapping("selectAllJust")
   @ApiOperation(value = "显示推荐的咨询师")
   public List<Master> selectAllJust(){
       List<Master> masters = masterService.queryAllJust();
       return masters;
   }

}
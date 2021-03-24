package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.entity.User;
import com.cs.heart_release_01.result.Result;
import com.cs.heart_release_01.result.ResultUtil;
import com.cs.heart_release_01.service.MasterService;
import com.cs.heart_release_01.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Guo Jiaqi
 * @version 1.0
 * @date 2021/1/17 15:53
 */
@RestController
@Api(tags = {"登陆"})
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;
    @Resource
    private MasterService masterService;

    @PostMapping("/user_login")
    @ApiOperation(value = "用户微信小程序登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "code", dataType = "String", required = true, value = "code")
    })
    public Result Userlogin(String code){
        if(code == null){
            return ResultUtil.Error("500","code为空",null);
        }
        String openId;
        try {
            openId = userService.login(code);
        }catch (Exception e){
            return ResultUtil.Error("500","登陆失败：",e.toString());
        }
        //判断数据库中有无该用户
        User user = userService.queryByOpenId(openId);
        //没有就创建
        if(user==null){
            User user1 = new User();
            user1.setOpenId(openId);
            User insert = userService.insert(user1);
            return ResultUtil.Success(insert);
        }else {
            return ResultUtil.Success(user);
        }

    }
    @PostMapping("/master_login")
    @ApiOperation(value = "咨询师微信小程序登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "code", dataType = "String", required = true, value = "code")
    })
    public Result Masterlogin(String code){
        if(code == null){
            return ResultUtil.Error("500","code为空",null);

        }
        String openId;
        try {
            openId = masterService.login(code);
            System.out.println(openId);
        }catch (Exception e){
            return ResultUtil.Error("500","登陆失败：",e.toString());

        }
        //判断数据库中有无该用户
        Master master = masterService.queryByOpenId(openId);

        //没有就创建
        if(master==null){
            Master master1 = new Master();
            master1.setOpenId(openId);
            Master insert = masterService.insert(master1);
            return ResultUtil.Success(insert);
        }else {
            System.out.println(master.toString());
            return ResultUtil.Success(master);
        }

    }
}

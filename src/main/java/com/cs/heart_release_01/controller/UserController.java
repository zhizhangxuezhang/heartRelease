package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.User;
import com.cs.heart_release_01.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("user")
@Api(tags = {"用户"})
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "根据id查询一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "用户id")
    })
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }
    //更新自己的资料
    @PutMapping("updateOne")
    @ApiOperation(value = "用户更新自己的资料")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "sex", dataType = "boolean", required = true, value = "性别<男t女f>"),
            @ApiImplicitParam(paramType = "query", name = "birthday", dataType = "String", required = true, value = "生日"),
            @ApiImplicitParam(paramType = "query", name = "brief_introduction", dataType = "String", required = true, value = "简介")
    })
    public User updateOne(Integer id, boolean sex, String birthday, String brief_introduction){
        User user = new User();
        user.setId(id);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setBriefIntroduction(brief_introduction);
        User user1 = userService.update(user);
        return user1;
    }

}
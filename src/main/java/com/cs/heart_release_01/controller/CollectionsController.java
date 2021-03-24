package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Collections;
import com.cs.heart_release_01.service.CollectionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Collection)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:26
 */
@RestController
@RequestMapping("/collections")
@Api(tags = {"收藏"})
public class CollectionsController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionsService collectionsService;

    //用户添加一个收藏
    @ApiOperation(value = "增加一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id")
    })
    @PostMapping("insertOne")
    public Collections insertOne(Integer user_id, Integer master_id){
        Collections c = new Collections();
        c.setMasterId(master_id);
        c.setUserId(user_id);
        Collections insert = collectionsService.insert(c);
        return insert;
    }
    //用户删除一个收藏
    @ApiOperation(value = "删除一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "收藏id")
    })
    @DeleteMapping("deleteOne")
    public boolean deleteOne(Integer id){
        boolean b = collectionsService.deleteById(id);
        return b;
    }
    //用户显示 自己的 所有收藏
    @ApiOperation(value = "用户显示自己的收藏")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id")
    })
    @GetMapping("selectMy")
    public List<Collections> selectMy(Integer user_id){
        Collections c = new Collections();
        c.setUserId(user_id);
        List<Collections> collections = collectionsService.queryAll(c);
        return collections;

    }
}
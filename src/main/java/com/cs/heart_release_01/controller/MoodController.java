package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.entity.Mood;
import com.cs.heart_release_01.oss.service.AliOssService;
import com.cs.heart_release_01.result.FileUploadResult;
import com.cs.heart_release_01.service.MoodService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Mood)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("mood")
@Api(tags = {"心情"})
public class MoodController {
    /**
     * 服务对象
     */
    @Resource
    private MoodService moodService;
    @Resource
    private AliOssService aliOssService;

    //查询所有的心情(非匿名)
    @GetMapping("selectAll")
    @ApiOperation(value = "查询所有非匿名心情")
    public List<Mood> selectAll(){
        Mood mood = new Mood();
        mood.setIsAnonymous(false);
        List<Mood> moods = moodService.queryAll(mood);
        return moods;
    }

    //查询自己的心情
    @GetMapping("selectByUserId")
    @ApiOperation(value = "查询用户自己的心情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id")
    })
    public List<Mood> selectByUserId(Integer user_id){
        List<Mood> moods = moodService.queryByUserId(user_id);
        return moods;
    }

    //增加自己的心情
    @PostMapping("createOne")
    @ApiOperation(value = "创建一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "content", dataType = "String", required = true, value = "心情文本"),
            @ApiImplicitParam(paramType = "query", name = "is_anonymous", dataType = "boolean", required = true, value = "是否匿名"),
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id")
    })
    public Mood createOne(String content, @ApiParam(value = "图片",required = false)MultipartFile picture, boolean is_anonymous, Integer user_id) throws IOException {
        //上传照片并放回文件路径
        String upload = aliOssService.upload(picture);
        //创建当前的时间并格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        //创建实例
        Mood mood = new Mood();
        mood.setContent(content);
        mood.setPicture(upload);
        mood.setIsAnonymous(is_anonymous);
        mood.setPublishTime(format);
        mood.setUserId(user_id);
        Mood insert = moodService.insert(mood);
        return insert;
    }
}
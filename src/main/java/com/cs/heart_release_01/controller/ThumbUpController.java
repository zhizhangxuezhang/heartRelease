package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.ThumbUp;
import com.cs.heart_release_01.service.ThumbUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (ThumbUp)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("thumbUp")
@Api(tags = {"点赞"})
public class ThumbUpController {
    /**
     * 服务对象
     */
    @Resource
    private ThumbUpService thumbUpService;



    //查看指定心情的点赞
    @GetMapping("selectByMoodId")
    @ApiOperation(value = "查看指定心情的所有点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mood_id", dataType = "int", required = true, value = "心情id")
    })
    public List<ThumbUp> selectByMoodId(Integer mood_id){
        ThumbUp thumbUp = new ThumbUp();
        thumbUp.setMoodId(mood_id);
        List<ThumbUp> thumbUps = thumbUpService.queryAll(thumbUp);
        return thumbUps;
    }
    //增加一个点赞
    @PostMapping("insertOne")
    @ApiOperation(value = "点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "mood_id", dataType = "int", required = true, value = "心情id")
    })
    public ThumbUp insertOne(Integer user_id,Integer mood_id){
        //创建实例
        ThumbUp thumbUp = new ThumbUp();
        //获取当前时间并转换格式
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);

        thumbUp.setThumbsUpTime(format);
        thumbUp.setMoodId(mood_id);
        thumbUp.setUserId(user_id);
        ThumbUp insert = thumbUpService.insert(thumbUp);
        return insert;
    }
    //删除一个点赞
    @DeleteMapping("deleteOne")
    @ApiOperation(value = "取消点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "赞id")
    })
    public boolean deleteOne(Integer id){
        boolean b = thumbUpService.deleteById(id);
        return b;
    }
}
package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Comment;
import com.cs.heart_release_01.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.joda.time.format.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:26
 */
@RestController
@RequestMapping("comment")
@Api(tags = {"评论"})
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;


    //增加
    @ApiOperation(value = "增加一个")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "text", dataType = "String", required = true, value = "评论内容"),
            @ApiImplicitParam(paramType = "query", name = "user_id", dataType = "int", required = true, value = "用户id"),
            @ApiImplicitParam(paramType = "query", name = "mood_id", dataType = "int", required = true, value = "心情id")

    })
    @PostMapping("insertOne")
    public Comment insertOne(String text,Integer user_id,Integer mood_id){
        //创建当前的时间并格式化
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        //创建实例
        Comment comment = new Comment();
        comment.setText(text);
        comment.setUserId(user_id);
        comment.setCommentTime(format);
        comment.setMoodId(mood_id);
        Comment insert = commentService.insert(comment);
        return insert;
    }
    //查询指定心情的全部评论
    @ApiOperation(value = "查找指定心情下的所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mood_id", dataType = "int", required = true, value = "心情id")
    })
    @GetMapping("queryAll")
    public List<Comment> queryAll(Integer mood_id){
        Comment comment = new Comment();
        comment.setMoodId(mood_id);
        List<Comment> comments = commentService.queryAll(comment);
        return comments;
    }
}
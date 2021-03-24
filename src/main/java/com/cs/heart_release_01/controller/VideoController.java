package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Music;
import com.cs.heart_release_01.entity.Video;
import com.cs.heart_release_01.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Video)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:29
 */
@RestController
@RequestMapping("video")
@Api(tags = {"视频"})
public class VideoController {
    /**
     * 服务对象
     */
    @Resource
    private VideoService videoService;


    /**
     * 查询所有数据
     *
     * @param
     * @return 所有数据
     */
    @GetMapping("selectAllJust")
    @ApiOperation(value = "查询所有")
    public List<Video> selectAllJust(){
        List<Video> videos = this.videoService.queryAllJust();
        return videos;
    }
}
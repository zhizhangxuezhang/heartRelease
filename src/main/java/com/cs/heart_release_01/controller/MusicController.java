package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Music;
import com.cs.heart_release_01.service.MusicService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Music)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("music")
@Api(tags = {"音乐"})
public class MusicController {
    /**
     * 服务对象
     */
    @Resource
    private MusicService musicService;

    /**
     * 查询多条数据
     *
     * @param
     * @return 多条数据
     */
    @GetMapping("selectAllJust")
    public List<Music> selectAllJust(){
        List<Music> musicList = this.musicService.queryAllJust();
        return musicList;
    }
}
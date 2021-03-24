package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Photo;
import com.cs.heart_release_01.service.PhotoService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Photo)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("photo")
@Api(tags = {"照片"})
public class PhotoController {
    /**
     * 服务对象
     */
    @Resource
    private PhotoService photoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Photo selectOne(Integer id) {
        return this.photoService.queryById(id);
    }

}
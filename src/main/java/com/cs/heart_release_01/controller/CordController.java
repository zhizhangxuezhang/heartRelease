package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.Cord;
import com.cs.heart_release_01.service.CordService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Cord)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:26
 */
@RestController
@RequestMapping("cord")
@Api(tags = {"心理健康评估记录"})
public class CordController {
    /**
     * 服务对象
     */
    @Resource
    private CordService cordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Cord selectOne(Integer id) {
        return this.cordService.queryById(id);
    }

}
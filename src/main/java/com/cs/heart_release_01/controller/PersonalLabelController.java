package com.cs.heart_release_01.controller;

import com.cs.heart_release_01.entity.PersonalLabel;
import com.cs.heart_release_01.service.PersonalLabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonalLabel)表控制层
 *
 * @author makejava
 * @since 2021-01-18 20:30:28
 */
@RestController
@RequestMapping("personalLabel")
@Api(tags = {"标签"})
public class PersonalLabelController {
    /**
     * 服务对象
     */
    @Resource
    private PersonalLabelService personalLabelService;

    //咨询师添加自己的标签
    @PostMapping("insertOne")
    @ApiOperation(value = "咨询师添加一个自己的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "String", required = true, value = "标签内容"),
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id")
    })
    public PersonalLabel insertOne(String name,Integer master_id){
        PersonalLabel pl = new PersonalLabel();
        pl.setMasterId(master_id);
        pl.setName(name);
        PersonalLabel insert = personalLabelService.insert(pl);
        return insert;
    }
    //咨询师查看（显示）自己的所有标签
    @GetMapping("selectAllJust")
    @ApiOperation(value = "咨询师查看自己的所有标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "master_id", dataType = "int", required = true, value = "咨询师id")
    })
    public List<PersonalLabel> selectAllJust(Integer master_id){
        PersonalLabel pl = new PersonalLabel();
        pl.setMasterId(master_id);
        List<PersonalLabel> personalLabels = personalLabelService.queryAll(pl);
        return personalLabels;
    }
    //咨询师删除自己的一个标签
    @DeleteMapping("deleteOne")
    @ApiOperation(value = "咨询师删除自己的一个标签")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "int", required = true, value = "标签id")
    })
    public boolean deleteOne(Integer id){
        boolean b = personalLabelService.deleteById(id);
        return b;
    }
}
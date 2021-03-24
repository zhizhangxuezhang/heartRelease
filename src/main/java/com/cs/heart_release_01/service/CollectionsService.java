package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.Collections;
import java.util.List;

/**
 * (Collection)表服务接口
 *
 * @author makejava
 * @since 2021-01-17 15:51:56
 */
public interface CollectionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Collections queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Collections> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param collection 实例对象
     * @return 实例对象
     */
    Collections insert(Collections collection);

    /**
     * 修改数据
     *
     * @param collection 实例对象
     * @return 实例对象
     */
    Collections update(Collections collection);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param collection 实例对象
     * @return 对象列表
     */
    List<Collections> queryAll(Collections collection);


}
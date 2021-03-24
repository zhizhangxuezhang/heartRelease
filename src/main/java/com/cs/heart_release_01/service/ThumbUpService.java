package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.ThumbUp;
import java.util.List;

/**
 * (ThumbUp)表服务接口
 *
 * @author makejava
 * @since 2021-01-17 15:52:06
 */
public interface ThumbUpService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ThumbUp queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ThumbUp> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param thumbUp 实例对象
     * @return 实例对象
     */
    ThumbUp insert(ThumbUp thumbUp);

    /**
     * 修改数据
     *
     * @param thumbUp 实例对象
     * @return 实例对象
     */
    ThumbUp update(ThumbUp thumbUp);

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
     * @param thumbUp 实例对象
     * @return 对象列表
     */
    List<ThumbUp> queryAll(ThumbUp thumbUp);

}
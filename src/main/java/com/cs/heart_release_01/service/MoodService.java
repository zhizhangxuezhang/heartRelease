package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.Mood;
import java.util.List;

/**
 * (Mood)表服务接口
 *
 * @author makejava
 * @since 2021-01-17 15:52:01
 */
public interface MoodService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mood queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mood> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    Mood insert(Mood mood);

    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    Mood update(Mood mood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * 通过userid查询mood
     *
     * @param user_id user_id
     * @return 实体类
     */
    List<Mood> queryByUserId(Integer user_id);
    /**
     * 查询所有
     *
     * @param
     * @return 对象列表
     */
    List<Mood> queryAllJust();
    /**
     * 通过实体作为筛选条件查询
     *
     * @param mood 实例对象
     * @return 对象列表
     */
    List<Mood> queryAll(Mood mood);

}
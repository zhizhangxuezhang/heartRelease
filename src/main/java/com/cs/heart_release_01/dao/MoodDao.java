package com.cs.heart_release_01.dao;

import com.cs.heart_release_01.entity.Mood;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Mood)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-17 15:52:01
 */
public interface MoodDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Mood queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Mood> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mood 实例对象
     * @return 对象列表
     */
    List<Mood> queryAll(Mood mood);

    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 影响行数
     */
    int insert(Mood mood);

    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 影响行数
     */
    int update(Mood mood);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 通过userid查询mood
     *
     * @param user_id user_id
     * @return 实体类
     */
    List<Mood> queryByUserId(Integer userId);
    /**
     * 查询所有
     *
     * @param
     * @return 对象列表
     */
    List<Mood> queryAllJust();
}
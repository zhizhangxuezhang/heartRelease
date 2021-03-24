package com.cs.heart_release_01.dao;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.entity.Music;
import com.cs.heart_release_01.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Master)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-20 14:49:07
 */
public interface MasterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Master queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Master> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param master 实例对象
     * @return 对象列表
     */
    List<Master> queryAll(Master master);

    /**
     * 新增数据
     *
     * @param master 实例对象
     * @return 影响行数
     */
    int insert(Master master);

    /**
     * 修改数据
     *
     * @param master 实例对象
     * @return 影响行数
     */
    int update(Master master);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    /**
     * 通过open_id查询数据
     *
     * @param openId wx小程序标识
     * @return 实例对象
     */
    Master queryByOpenId(String openId);

    /**
     * 查询所有数据
     *
     * @param
     * @return List
     */
    List<Master> queryAllJust();

}
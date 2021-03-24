package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.Master;
import java.util.List;

/**
 * (Master)表服务接口
 *
 * @author makejava
 * @since 2021-01-20 14:49:08
 */
public interface MasterService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Master queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Master> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param master 实例对象
     * @return 实例对象
     */
    Master insert(Master master);

    /**
     * 修改数据
     *
     * @param master 实例对象
     * @return 实例对象
     */
    Master update(Master master);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    String login(String code);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Master queryByOpenId(String openId);

    /**
     * 查询最新的数据
     *
     * @param
     * @return 实体类
     */
    Master queryNewest();
    /**
     * 查询所有的数据（推荐机制）
     *
     * @param
     * @return List
     */
    List<Master> queryAllJust();
}
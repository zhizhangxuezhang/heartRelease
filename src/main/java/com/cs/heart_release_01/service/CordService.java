package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.Cord;
import java.util.List;

/**
 * (Cord)表服务接口
 *
 * @author makejava
 * @since 2021-01-17 15:51:59
 */
public interface CordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cord queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Cord> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cord 实例对象
     * @return 实例对象
     */
    Cord insert(Cord cord);

    /**
     * 修改数据
     *
     * @param cord 实例对象
     * @return 实例对象
     */
    Cord update(Cord cord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
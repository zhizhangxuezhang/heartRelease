package com.cs.heart_release_01.service;

import com.cs.heart_release_01.entity.Music;
import java.util.List;

/**
 * (Music)表服务接口
 *
 * @author makejava
 * @since 2021-01-17 15:52:02
 */
public interface MusicService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Music queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Music> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param music 实例对象
     * @return 实例对象
     */
    Music insert(Music music);

    /**
     * 修改数据
     *
     * @param music 实例对象
     * @return 实例对象
     */
    Music update(Music music);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有数据
     *
     * @param
     * @return List
     */
    List<Music> queryAllJust();

}
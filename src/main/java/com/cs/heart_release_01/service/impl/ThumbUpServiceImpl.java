package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.ThumbUp;
import com.cs.heart_release_01.dao.ThumbUpDao;
import com.cs.heart_release_01.service.ThumbUpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ThumbUp)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:52:06
 */
@Service
public class ThumbUpServiceImpl implements ThumbUpService {
    @Resource
    private ThumbUpDao thumbUpDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ThumbUp queryById(Integer id) {
        return this.thumbUpDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ThumbUp> queryAllByLimit(int offset, int limit) {
        return this.thumbUpDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param thumbUp 实例对象
     * @return 实例对象
     */
    @Override
    public ThumbUp insert(ThumbUp thumbUp) {
        this.thumbUpDao.insert(thumbUp);
        return thumbUp;
    }

    /**
     * 修改数据
     *
     * @param thumbUp 实例对象
     * @return 实例对象
     */
    @Override
    public ThumbUp update(ThumbUp thumbUp) {
        this.thumbUpDao.update(thumbUp);
        return this.queryById(thumbUp.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.thumbUpDao.deleteById(id) > 0;
    }

    @Override
    public List<ThumbUp> queryAll(ThumbUp thumbUp) {
        List<ThumbUp> thumbUps = thumbUpDao.queryAll(thumbUp);
        return thumbUps;
    }

}
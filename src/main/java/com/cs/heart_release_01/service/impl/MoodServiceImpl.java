package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Mood;
import com.cs.heart_release_01.dao.MoodDao;
import com.cs.heart_release_01.service.MoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Mood)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:52:01
 */
@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodDao moodDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Mood queryById(Integer id) {
        return this.moodDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Mood> queryAllByLimit(int offset, int limit) {
        return this.moodDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    @Override
    public Mood insert(Mood mood) {
        this.moodDao.insert(mood);
        return mood;
    }

    /**
     * 修改数据
     *
     * @param mood 实例对象
     * @return 实例对象
     */
    @Override
    public Mood update(Mood mood) {
        this.moodDao.update(mood);
        return this.queryById(mood.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.moodDao.deleteById(id) > 0;
    }

    @Override
    public List<Mood> queryByUserId(Integer user_id) {
        List<Mood> moods = moodDao.queryByUserId(user_id);
        return moods;
    }

    @Override
    public List<Mood> queryAllJust() {
        List<Mood> moods = moodDao.queryAllJust();
        return moods;
    }

    @Override
    public List<Mood> queryAll(Mood mood) {
        List<Mood> moods = moodDao.queryAll(mood);
        return moods;
    }
}
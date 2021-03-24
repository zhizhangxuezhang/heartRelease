package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Cord;
import com.cs.heart_release_01.dao.CordDao;
import com.cs.heart_release_01.service.CordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cord)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:51:59
 */
@Service
public class CordServiceImpl implements CordService {
    @Resource
    private CordDao cordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cord queryById(Integer id) {
        return this.cordDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Cord> queryAllByLimit(int offset, int limit) {
        return this.cordDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cord 实例对象
     * @return 实例对象
     */
    @Override
    public Cord insert(Cord cord) {
        this.cordDao.insert(cord);
        return cord;
    }

    /**
     * 修改数据
     *
     * @param cord 实例对象
     * @return 实例对象
     */
    @Override
    public Cord update(Cord cord) {
        this.cordDao.update(cord);
        return this.queryById(cord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cordDao.deleteById(id) > 0;
    }
}
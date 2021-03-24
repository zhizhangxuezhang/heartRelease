package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Collections;
import com.cs.heart_release_01.dao.CollectionsDao;
import com.cs.heart_release_01.service.CollectionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * (Collection)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:51:57
 */
@Service
public class CollectionsServiceImpl implements CollectionsService {
    @Resource
    private CollectionsDao collectionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Collections queryById(Integer id) {
        return this.collectionsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Collections> queryAllByLimit(int offset, int limit) {
        return this.collectionsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param collection 实例对象
     * @return 实例对象
     */
    @Override
    public Collections insert(Collections collection) {
        this.collectionsDao.insert(collection);
        return collection;
    }

    /**
     * 修改数据
     *
     * @param collection 实例对象
     * @return 实例对象
     */
    @Override
    public Collections update(Collections collection) {
        this.collectionsDao.update(collection);
        return this.queryById(collection.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.collectionsDao.deleteById(id) > 0;
    }

    @Override
    public List<Collections> queryAll(Collections collection) {
        List<Collections> collections = collectionsDao.queryAll(collection);
        return collections;
    }
}
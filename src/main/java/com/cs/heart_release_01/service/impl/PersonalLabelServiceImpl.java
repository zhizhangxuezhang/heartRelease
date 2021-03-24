package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.PersonalLabel;
import com.cs.heart_release_01.dao.PersonalLabelDao;
import com.cs.heart_release_01.service.PersonalLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PersonalLabel)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:52:04
 */
@Service
public class PersonalLabelServiceImpl implements PersonalLabelService {
    @Resource
    private PersonalLabelDao personalLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PersonalLabel queryById(Integer id) {
        return this.personalLabelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PersonalLabel> queryAllByLimit(int offset, int limit) {
        return this.personalLabelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param personalLabel 实例对象
     * @return 实例对象
     */
    @Override
    public PersonalLabel insert(PersonalLabel personalLabel) {
        this.personalLabelDao.insert(personalLabel);
        return personalLabel;
    }

    /**
     * 修改数据
     *
     * @param personalLabel 实例对象
     * @return 实例对象
     */
    @Override
    public PersonalLabel update(PersonalLabel personalLabel) {
        this.personalLabelDao.update(personalLabel);
        return this.queryById(personalLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.personalLabelDao.deleteById(id) > 0;
    }

    @Override
    public List<PersonalLabel> queryAllJust() {
        List<PersonalLabel> personalLabels = personalLabelDao.queryAllJust();
        return personalLabels;
    }

    @Override
    public List<PersonalLabel> queryAll(PersonalLabel personalLabel) {
        List<PersonalLabel> personalLabels = personalLabelDao.queryAll(personalLabel);
        return personalLabels;

    }
}
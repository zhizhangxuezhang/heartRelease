package com.cs.heart_release_01.dao;

import com.cs.heart_release_01.entity.PersonalLabel;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (PersonalLabel)表数据库访问层
 *
 * @author makejava
 * @since 2021-01-17 15:52:03
 */
public interface PersonalLabelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PersonalLabel queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PersonalLabel> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param personalLabel 实例对象
     * @return 对象列表
     */
    List<PersonalLabel> queryAll(PersonalLabel personalLabel);

    /**
     * 新增数据
     *
     * @param personalLabel 实例对象
     * @return 影响行数
     */
    int insert(PersonalLabel personalLabel);

    /**
     * 修改数据
     *
     * @param personalLabel 实例对象
     * @return 影响行数
     */
    int update(PersonalLabel personalLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询所有数据
     *
     * @param
     * @return List
     */
    List<PersonalLabel> queryAllJust();
}
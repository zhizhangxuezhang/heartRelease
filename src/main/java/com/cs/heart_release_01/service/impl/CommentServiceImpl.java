package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Comment;
import com.cs.heart_release_01.dao.CommentDao;
import com.cs.heart_release_01.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Comment)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:51:58
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentDao commentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Comment queryById(Integer id) {
        return this.commentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Comment> queryAllByLimit(int offset, int limit) {
        return this.commentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment insert(Comment comment) {
        this.commentDao.insert(comment);
        return comment;
    }

    /**
     * 修改数据
     *
     * @param comment 实例对象
     * @return 实例对象
     */
    @Override
    public Comment update(Comment comment) {
        this.commentDao.update(comment);
        return this.queryById(comment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.commentDao.deleteById(id) > 0;
    }

    @Override
    public List<Comment> queryAll(Comment comment) {
        List<Comment> comments = commentDao.queryAll(comment);
        return comments;
    }


}
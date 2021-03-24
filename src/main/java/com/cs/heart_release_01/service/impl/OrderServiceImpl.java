package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Order;
import com.cs.heart_release_01.dao.OrderDao;
import com.cs.heart_release_01.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-01-17 15:52:03
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    @Override
    public List<Order> queryAll(Order order) {
        List<Order> orders = orderDao.queryAll(order);
        return orders;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderDao.deleteById(id) > 0;
    }
}
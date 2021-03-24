package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.User;
import com.cs.heart_release_01.dao.UserDao;
import com.cs.heart_release_01.service.UserService;
import com.cs.heart_release_01.util.Http;
import com.cs.heart_release_01.util.JsonUtils;
import com.cs.heart_release_01.wx.WXSessionModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 14:49:04
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public String login(String code) {
        //微信获取openid和sessionkey的url
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        //map集合存放信息
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wx0bf4467902a62fb9");
        param.put("secret", "b6e097679dea769c3e78615bf90334b7");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");

        //调用自定义的doget方法，返回一个带有openid和sessionkey的string类型的结果
        String wxResult = Http.doGet(url, param);
        System.out.println(wxResult);
        //将结果转化为model的形式--格式转换
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        //获取open_id
        String open_id = model.getOpenid();
        return open_id;
    }

    @Override
    public User queryByOpenId(String openId) {
        User user = userDao.queryByOpenId(openId);
        return user;
    }
}
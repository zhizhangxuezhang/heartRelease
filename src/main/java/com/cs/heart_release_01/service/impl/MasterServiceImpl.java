package com.cs.heart_release_01.service.impl;

import com.cs.heart_release_01.entity.Master;
import com.cs.heart_release_01.dao.MasterDao;
import com.cs.heart_release_01.service.MasterService;
import com.cs.heart_release_01.util.Http;
import com.cs.heart_release_01.util.JsonUtils;
import com.cs.heart_release_01.wx.WXSessionModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Master)表服务实现类
 *
 * @author makejava
 * @since 2021-01-20 14:49:09
 */
@Service
public class MasterServiceImpl implements MasterService {
    @Resource
    private MasterDao masterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Master queryById(Integer id) {
        return this.masterDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Master> queryAllByLimit(int offset, int limit) {
        return this.masterDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param master 实例对象
     * @return 实例对象
     */
    @Override
    public Master insert(Master master) {
        this.masterDao.insert(master);
        return master;
    }

    /**
     * 修改数据
     *
     * @param master 实例对象
     * @return 实例对象
     */
    @Override
    public Master update(Master master) {
        this.masterDao.update(master);
        return this.queryById(master.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.masterDao.deleteById(id) > 0;
    }

    @Override
    public String login(String code) {
        //微信获取openid和sessionkey的url
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        //map集合存放信息
        Map<String, String> param = new HashMap<>();
        param.put("appid", "wx0bf4467902a62fb9");
        param.put("secret", "xxxxxx");
        param.put("js_code", code);
        param.put("grant_type", "authorization_code");
        //调用自定义的doget方法，返回一个带有openid和sessionkey的string类型的结果
        String wxResult = Http.doGet(url, param);
        //将结果转化为model的形式--格式转换
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
        //获取open_id
        String open_id = model.getOpenid();
        return open_id;
    }

    @Override
    public Master queryByOpenId(String openId) {
        Master master = masterDao.queryByOpenId(openId);
        return master;
    }
    //查询最新的
    @Override
    public Master queryNewest() {
        List<Master> masters = masterDao.queryAllJust();
        int size = masters.size();
        Master master = masters.get(size - 1);
        return master;
    }

    //查询所有（推荐机制）
    @Override
    public List<Master> queryAllJust() {
        List<Master> masters = masterDao.queryAllJust();
        return masters;
    }

}

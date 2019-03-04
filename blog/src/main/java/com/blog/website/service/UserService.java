package com.blog.website.service;

import com.blog.website.common.PageView;
import com.blog.website.entity.User;
import com.blog.website.entity.UserExample;
import com.blog.website.mapper.UserMapper;
import com.blog.website.service.base.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author jiangzehao
 * @date 2019/3/4 15:53
 */
@Service
public class UserService implements BaseService<User,Integer> {
    @Autowired
    private UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(getClass());


    public UserExample setConditionValue(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();

        if(user.getUserId() != null){
            criteria.andUserIdEqualTo(user.getUserId());
        }
        if(user.getUserName()!=null){
            criteria.andUserNameEqualTo(user.getUserName());
        }
        if(user.getUserEmail()!=null){
            criteria.andUserEmailEqualTo(user.getUserEmail());
        }
        return userExample;
    }

    @Override
    public List<User> queryAll(User user) {

        return null;
    }

    @Override
    public void update(User user) throws Exception {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(Integer id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getByKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(User user) throws Exception {
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    public PageInfo<User> getList(PageView pageView ,User user){
        PageHelper.startPage(pageView.getPageNow(),pageView.getPageSize());
        List<User> list = userMapper.selectByExample(setConditionValue(user));
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}

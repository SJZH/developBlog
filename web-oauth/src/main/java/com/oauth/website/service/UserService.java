package com.oauth.website.service;


import com.common.common.PageView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oauth.website.entity.User;
import com.oauth.website.entity.UserExample;
import com.oauth.website.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author jiangzehao
 * @date 2019/3/6 10:21
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.getByName(s);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public User getByName(String name){
        return userMapper.getByName(name);
    }

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

    public List<User> queryAll(User user) {

        return null;
    }

    public void update(User user) throws Exception {
        userMapper.updateByPrimaryKey(user);
    }

    public void delete(Integer id) throws Exception {
        userMapper.deleteByPrimaryKey(id);
    }

    public User getByKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void add(User user) throws Exception {
        user.setCreateTime(new Date());
        userMapper.insertSelective(user);
    }

    public PageInfo<User> getList(PageView pageView , User user){
        PageHelper.startPage(pageView.getPageNow(),pageView.getPageSize());
        List<User> list = userMapper.selectByExample(setConditionValue(user));
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

}

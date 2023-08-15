package com.duchong.demo.user;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duchong.demo.domain.user.User;
import com.duchong.demo.domain.user.gateway.UserGateway;
import com.duchong.demo.user.mapper.JtestUserMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:47
 **/
@Component
public class UserGatewayImpl extends ServiceImpl<JtestUserMapper,JtestUserDO> implements UserGateway {


    @Override
    public void create(User user) {
        JtestUserDO jtestUserDO = new JtestUserDO();
        BeanUtils.copyProperties(user,jtestUserDO);
        baseMapper.insert(jtestUserDO);
    }

    @Override
    public User getById(Integer id) {
        JtestUserDO jtestUserDO = baseMapper.selectById(id);
        User user = new User();
        BeanUtils.copyProperties(jtestUserDO,user);
        return user;
    }

    @Override
    public void update(User user) {
        JtestUserDO jtestUserDO = new JtestUserDO();
        BeanUtils.copyProperties(user,jtestUserDO);
        baseMapper.updateById(jtestUserDO);
    }

    @Override
    public List<User> listUser() {


        List<User> userList = Lists.newArrayList();
        List<JtestUserDO> userDOList = baseMapper.selectList(Wrappers.query());

        userList=userDOList.stream().map(var->{
            User user = new User();
            BeanUtils.copyProperties(var,user);
            return user;
        }).collect(Collectors.toList());

        return userList;
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);
    }
}

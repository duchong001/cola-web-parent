package com.duchong.demo.user.executor.cmd;

import com.duchong.demo.domain.user.User;
import com.duchong.demo.domain.user.gateway.UserGateway;
import com.duchong.demo.user.req.AddUserReq;
import com.duchong.demo.user.req.UpdateUserReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:39
 **/
@Component
public class UserCmdExe {

    @Autowired
    private UserGateway userGateway;


    public void create(AddUserReq addUserReq) {

        User user = new User();
        BeanUtils.copyProperties(addUserReq,user);
        userGateway.create(user);
    }

    public void update(Integer id, UpdateUserReq updateUserReq) {

        User user = userGateway.getById(id);
        BeanUtils.copyProperties(updateUserReq,user);
        userGateway.update(user);

    }

    public void delete(Integer id) {
        userGateway.deleteById(id);
    }
}

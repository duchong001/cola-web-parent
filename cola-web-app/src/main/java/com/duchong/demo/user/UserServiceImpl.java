package com.duchong.demo.user;

import com.duchong.demo.user.dto.UserDTO;
import com.duchong.demo.user.req.AddUserReq;
import com.duchong.demo.user.req.UpdateUserReq;
import com.duchong.demo.user.executor.cmd.UserCmdExe;
import com.duchong.demo.user.executor.query.UserQueryExe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:38
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserCmdExe userCmdExe;

    @Autowired
    UserQueryExe userQueryExe;

    @Override
    public void create(AddUserReq addUserReq) {
        userCmdExe.create(addUserReq);
    }

    @Override
    public void update(Integer id, UpdateUserReq updateUserReq) {
        userCmdExe.update(id,updateUserReq);
    }

    @Override
    public void delete(Integer id) {
        userCmdExe.delete(id);
    }

    @Override
    public UserDTO getById(Integer id) {
        return userQueryExe.getById(id);
    }

    @Override
    public List<UserDTO> list() {
        return userQueryExe.list();
    }
}

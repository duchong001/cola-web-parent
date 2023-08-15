package com.duchong.demo.user;

import com.duchong.demo.user.dto.UserDTO;
import com.duchong.demo.user.req.AddUserReq;
import com.duchong.demo.user.req.UpdateUserReq;

import java.util.List;

public interface UserService {

    void create(AddUserReq addUserReq);

    void update(Integer id, UpdateUserReq updateUserReq);

    void delete(Integer id);

    UserDTO getById(Integer id);

    List<UserDTO> list();
}

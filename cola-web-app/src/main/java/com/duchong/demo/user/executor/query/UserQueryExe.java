package com.duchong.demo.user.executor.query;

import com.duchong.demo.domain.user.User;
import com.duchong.demo.domain.user.gateway.UserGateway;
import com.duchong.demo.user.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:39
 **/
@Component
public class UserQueryExe {

    @Autowired
    private UserGateway userGateway;


    public UserDTO getById(Integer id) {
        User user = userGateway.getById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }


    public List<UserDTO> list() {

        List<User> userList = userGateway.listUser();
        return userList.stream().map(var -> {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(var, userDTO);
            return userDTO;
        }).collect(Collectors.toList());
    }
}

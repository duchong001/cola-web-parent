package com.duchong.demo.domain.user.gateway;


import com.duchong.demo.domain.user.User;

import java.util.List;

public interface UserGateway {
    void create(User user);

    User getById(Integer id);

    void update(User user);

    List<User> listUser();

    void deleteById(Integer id);
}

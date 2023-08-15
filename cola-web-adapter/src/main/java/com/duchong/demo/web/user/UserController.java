package com.duchong.demo.web.user;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.duchong.demo.user.UserService;
import com.duchong.demo.user.dto.UserDTO;
import com.duchong.demo.user.req.AddUserReq;
import com.duchong.demo.user.req.UpdateUserReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:41
 **/
@Api(tags = "User Restful API")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "创建用户")
    @PostMapping("create")
    public Response create(@RequestBody AddUserReq addUserReq){

        userService.create(addUserReq);
        return SingleResponse.buildSuccess();
    }

    @ApiOperation(value = "查询用户")
    @GetMapping("get/{id}")
    public Response get(@PathVariable("id") Integer id){

        UserDTO user = userService.getById(id);

        return SingleResponse.of(user);
    }

    @ApiOperation(value = "列表用户")
    @GetMapping("list")
    public Response list(){
        List<UserDTO> userList = userService.list();
        return SingleResponse.of(userList);
    }

    @ApiOperation(value = "更新用户")
    @PutMapping("update/{id}")
    public Response update(@PathVariable("id") Integer id, @RequestBody UpdateUserReq updateUserReq){

        userService.update(id,updateUserReq);

        return SingleResponse.buildSuccess();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") Integer id){

        userService.delete(id);

        return SingleResponse.buildSuccess();
    }

}

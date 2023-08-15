package com.duchong.demo.user.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:32
 **/
@Data
public class UserDTO {

    private Integer id;

    private String name;

    private Integer age;

    private String createdBy;

    private Date gmtCreate;

    private String modifiedBy;

    private Date gmtModify;

    private String deletedBy;

    private Date gmtDelete;

    private Integer deleted;
}

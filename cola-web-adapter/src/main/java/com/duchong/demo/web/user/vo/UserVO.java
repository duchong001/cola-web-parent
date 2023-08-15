package com.duchong.demo.web.user.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author DUCHONG
 * @date 2023-08-14 14:42
 **/
@Data
public class UserVO {

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

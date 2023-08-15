package com.duchong.demo.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.duchong.demo.base.CommonTableField;
import lombok.Data;

/**
 * 测试用户表
 * @TableName jtest_user
 */
@TableName(value ="jtest_user")
@Data
public class JtestUserDO extends CommonTableField {

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;



    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
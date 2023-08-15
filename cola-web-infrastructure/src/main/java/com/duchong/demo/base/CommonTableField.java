package com.duchong.demo.base;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 数据库公共字段
 * @author: aman.wang
 * @date: 2022-10-13
 * @version: 1.0
 */
@Data
public class CommonTableField implements Serializable {

    private static final long serialVersionUID = 4733930494445375534L;
    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 修改人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifiedBy;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModify;

    /**
     * 删除人
     */
    @TableField(fill = FieldFill.DEFAULT)
    private String deletedBy;

    /**
     * 删除时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date gmtDelete;

    /**
     * 是否删除(0:否,1:是)
     */
    @TableLogic(value = "0",delval = "1")
    @TableField(fill = FieldFill.INSERT, select = false)
    private Integer deleted;

    //@Version
    //private Integer version;

}

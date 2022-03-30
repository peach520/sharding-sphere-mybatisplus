package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author YYT
 * @Date 2022/3/25 18:16
 * 建表语句  uc_department
CREATE TABLE `uc_department` (
`id` bigint(20) NOT NULL,
`deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 1:删除；0：正常',
`gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
`gmt_modify` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`create_user` varchar(64) NOT NULL DEFAULT '',
`modify_user` varchar(64) DEFAULT '',
`db_remark` varchar(255) DEFAULT NULL COMMENT '备注',
`org_id` varchar(48) NOT NULL COMMENT '组织id',
`dept_id` varchar(48) NOT NULL COMMENT '部门id',
`dept_name` varchar(48) NOT NULL COMMENT '部门名字',
PRIMARY KEY (`id`),
KEY `uc_department_org_id_dept_name_index` (`org_id`,`dept_name`),
KEY `idx_org_dept` (`org_id`,`dept_id`) USING BTREE,
KEY `idx_org_id_id` (`org_id`,`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表'

 **/
@Data
@TableName("uc_department")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UcDepartmentDO {

    private Long id;
    private String orgId;
    private String deptId;
    private String deptName;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtModify;

    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String modifyUser;

    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

}

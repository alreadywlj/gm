package com.gm.content.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 字典entity
 */
@Table(name = "dictionary")
@Entity
@Data
public class Dictionary implements Serializable {
    @Id
    @Column(name = "d_id")
    private int dId;  //主键

    @Column(name = "d_desc", length = 50)
    @NotBlank(message = "字典描述不允许为空")
    @Length(min = 10, max = 50, message = "字典描述为10-50个字符")
    private String desc; //描述

    @Column(name = "d_name", length = 10)
    @NotBlank(message = "字典名称不允许为空")  //验证字符串非null
    @Length(min = 2, max = 20, message = "字典名称为2  -20个字符")
    private String name;//字典名称n

    @Column(name = "create_user", length = 32)
    private String createUser;//创建人

    @Column(name = "update_user", length = 32)
    private String updateUser;//修改人

    @Column(name = "cre_time")
    private Date creTime;//创建时间

    @Column(name = "upd_time")
    private Date updTime;//修改时间


}

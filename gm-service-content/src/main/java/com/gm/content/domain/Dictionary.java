package com.gm.content.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 字典entity
 */
@Table(name = "dictionary")
@Entity
public class Dictionary  implements Serializable {
    @Id
    @Column(name = "d_id", length = 32)
    private String dId;  //主键

    @Column(name = "d_desc", length = 50)
    private String dDesc; //描述

    @Column(name = "d_name", length = 10)
    @NotBlank  //验证字符串非null
    @Length(min=2,max=20,message = "字典名称为2  -20个字符")
    private String dName;//字典名称

    @Column(name = "create_user", length = 32)
    private String createUser;//创建人

    @Column(name = "update_user", length = 32)
    private String updateUser;//创建时间

    @Column(name = "cre_time")
    private Date creTime;//创建时间

    @Column(name = "upd_time")
    private Date updTime;//修改时间

    public Dictionary(String dId, String dDesc, String dName, String createUser, String updateUser, Date creTime, Date updTime) {
        this.dId = dId;
        this.dDesc = dDesc;
        this.dName = dName;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.creTime = creTime;
        this.updTime = updTime;
    }

    public Dictionary() {
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdDesc() {
        return dDesc;
    }

    public void setdDesc(String dDesc) {
        this.dDesc = dDesc;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dId='" + dId + '\'' +
                ", dDesc='" + dDesc + '\'' +
                ", dName='" + dName + '\'' +
                ", createUser='" + createUser + '\'' +
                ", updateUser='" + updateUser + '\'' +
                ", creTime=" + creTime +
                ", updTime=" + updTime +
                '}';
    }

}

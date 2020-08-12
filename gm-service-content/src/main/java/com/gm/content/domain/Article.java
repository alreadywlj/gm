package com.gm.content.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * NotNull :不能为null，但可以为empty
 * NotEmpty: 不能为null，而且长度必须大于0
 * NotBlank: 只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 */
@Entity
@Data
@Table(name = "article")
public class Article implements Serializable {

    // @NotEmpty // 不能作用与String

    private static final long serialVersionUID = 1L;

    //配置uuid，本来jpa是不支持uuid的，但借用hibernate的方法可以实现。
    @Id
    @Column(name = "a_id", length = 32)
    private String aId;

    @Column(name = "cre_user")
    private String creUser;

    @Column(name = "upd_user")
    private String updUser;

    private String images;

    @NotBlank(message = "文章内容不允许为空")
    private String data;

    @Column(name = "cre_time")
    private Date creTime;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "a_status")
    @NotNull(message = "文章状态不能为null")
    @Range(min = 1,max = 2,message = "文章状态只能为1或者2")
    private Integer status;

    @NotBlank(message = "文章标题不允许为空")  //只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
    @Length(min = 10, max = 50, message = "文章标题为10-50个字符")
    private String title;
}

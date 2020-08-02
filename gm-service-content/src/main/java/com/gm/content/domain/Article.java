package com.gm.content.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "a_id")
    private String aId;

    @Column(name = "cre_user")
    private String creUser;

    @Column(name = "upd_user")
    private String updUser;

    private String images;

    @NotBlank
    private String data;

    @Column(name = "cre_time")
    private Date creTime;

    @Column(name = "upd_time")
    private Date updTime;

    @Column(name = "a_status")
    @NotEmpty
    @Length(max = 1)
    private Integer aStatus;

    @NotBlank(message = "文章标题不允许为空")
    @Length(min = 10, max = 50, message = "文章标题为10-50个字符")
    private Integer title;
}

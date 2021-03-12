package org.jiaopi.pojo;

//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "user", value = "user")
@Table(name = "tb_user")
public class User implements Serializable {
    @ApiModelProperty(value = "user id", required = false)
    @Id
    @Column(name = "id")
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long id; // 编号

    @ApiModelProperty(value = "user name", required = false)
    @Column(name = "name")
    private String name; // user名称

    @ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time")
    private Date updateTime = new Date();

    @ApiModelProperty(value = "课程信息")
    @JoinColumn(name = "curriculum_id", table = "tb_curriculum")
    private Curriculum curriculum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
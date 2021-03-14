package org.jiaopi.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "curriculum", value = "课程")
@Table(name = "tb_curriculum")
@Entity
public class Curriculum implements Serializable {

    private static final long serialVersionUID = 8638763266243872066L;
    @ApiModelProperty(value = "curriculum id", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "curriculum name", required = false)
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "curriculum create time", required = false)
    @Column(name = "create_time")
    private Date createTime = new Date();

    @ApiModelProperty(value = "curriculum update time", required = false)
    @Column(name = "update_time")
    private Date updateTime = new Date();

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

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

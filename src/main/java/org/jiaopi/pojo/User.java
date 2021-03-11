package org.jiaopi.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//import javax.persistence.Column;
//import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "user", value = "user")
@Table(name = "tb_user")
public class User extends BaseModel implements Serializable {
    @ApiModelProperty(value = "user id", required = false)
    @Column(name = "id", type = MySqlTypeConstant.INT, length = 11, isKey = true, isAutoIncrement = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id; // 编号

    @ApiModelProperty(value = "user name", required = false)
    @Column(name = "name", type = MySqlTypeConstant.VARCHAR, length = 111)
    private String name; // user名称

    @ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time", type = MySqlTypeConstant.DATETIME)
    private Date createTime;

    @ApiModelProperty(value = "更新时间",required = false)
    @Column(name = "update_time", type = MySqlTypeConstant.DATETIME)
    private Date updateTime;

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

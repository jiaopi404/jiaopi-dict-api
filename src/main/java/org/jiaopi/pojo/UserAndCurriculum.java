package org.jiaopi.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "user and curriculum", value = "课程")
@Table(name = "tb_user_and_curriculum")
@Entity
public class UserAndCurriculum implements Serializable {
    @ApiModelProperty(value = "user and curriculum id", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "curriculum id", required = false)
    @Column(name = "curriculum_id")
    private Long curriculumId;

    @ApiModelProperty(value = "curriculum create time", required = false)
    @Column(name = "user_id")
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(Long curriculumId) {
        this.curriculumId = curriculumId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

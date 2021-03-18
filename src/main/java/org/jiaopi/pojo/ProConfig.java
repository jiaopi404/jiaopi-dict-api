package org.jiaopi.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@ApiModel(description = "pro config", value = "pro config")
@Table(name = "tb_pro_config")
@Entity
public class ProConfig implements Serializable {
    private static final long serialVersionUID = -3724110803454564685L;

    @ApiModelProperty(value = "pro config id", required = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(value = "wx id", required = false)
    @Column(name = "wx_id")
    private String wxId;

    @ApiModelProperty(value = "wx secret", required = false)
    @Column(name = "wx_secret")
    private String wxSecret;

    @ApiModelProperty(value = "api key", required = false)
    @Column(name = "api_key")
    private String apiKey;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getWxSecret() {
        return wxSecret;
    }

    public void setWxSecret(String wxSecret) {
        this.wxSecret = wxSecret;
    }
}

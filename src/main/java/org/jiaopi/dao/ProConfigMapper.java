package org.jiaopi.dao;

//import org.jiaopi.pojo.User;
import org.jiaopi.pojo.ProConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.stereotype.Repository;

public interface ProConfigMapper extends JpaRepository<ProConfig, Long>, JpaSpecificationExecutor<ProConfig> {
    /**
     * 根据
     * @param apiKey
     * @return
     */
    ProConfig getProConfigByApiKey (String apiKey);
}

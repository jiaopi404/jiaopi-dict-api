package org.jiaopi.service;

import org.jiaopi.pojo.ProConfig;

public interface ProConfigService {
    /**
     * 根据 api key 获取配置信息
     * @param apiKey apiKey
     * @return ProConfig
     */
    ProConfig getProConfigByApiKey (String apiKey);
}

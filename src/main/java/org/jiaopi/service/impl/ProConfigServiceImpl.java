package org.jiaopi.service.impl;

import org.jiaopi.dao.ProConfigMapper;
import org.jiaopi.pojo.ProConfig;
import org.jiaopi.service.ProConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProConfigServiceImpl implements ProConfigService {
    @Autowired
    private ProConfigMapper proConfigMapper;

    /**
     * 根据 api key 获取 proConfig
     * @param apiKey apiKey
     * @return
     */
    @Override
    public ProConfig getProConfigByApiKey(String apiKey) {
        return proConfigMapper.getProConfigByApiKey(apiKey);
    }
}

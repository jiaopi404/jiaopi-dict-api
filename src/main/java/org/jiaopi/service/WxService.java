package org.jiaopi.service;

import com.alibaba.fastjson.JSONObject;

public interface WxService {
    JSONObject wxLogin(String apiKey, String jsCode);
}

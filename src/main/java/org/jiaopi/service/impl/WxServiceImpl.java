package org.jiaopi.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jiaopi.pojo.ProConfig;
import org.jiaopi.service.ProConfigService;
import org.jiaopi.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WxServiceImpl implements WxService {
    @Autowired
    private ProConfigService proConfigService;

    @Override
    public JSONObject wxLogin(String apiKey, String jsCode) {
        // 根据 apiKey 获取 proConfig
        ProConfig proConfig = proConfigService.getProConfigByApiKey(apiKey);
        String appId = proConfig.getWxId(); // appId
        String secret = proConfig.getWxSecret(); // 秘钥
        String grantType = "authorization_code"; // 授权类型
        // 获得 http 客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 组织 url
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appId +
                "&secret=" + secret + "&js_code=" + jsCode + "&grant_type=" +
                grantType;
        // 创建 get 请求
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;

        JSONObject jsonObject = null;

        try {
            // 由客户端执行（发送）GET 请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 获取内容
                System.out.println("响应内容长度： " + httpEntity.getContentLength());
                String responseText = EntityUtils.toString(httpEntity);
                System.out.println("响应内容： " + responseText);
                jsonObject = JSONObject.parseObject(responseText);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}

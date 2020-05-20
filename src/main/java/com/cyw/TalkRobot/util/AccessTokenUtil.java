package com.cyw.TalkRobot.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * 获取Token
 *
 * @author cyw
 * @date 2020/5/19 16:49
 */
@Component
public class AccessTokenUtil {

    /**
     * token Url
     */
    @Value("${baidu_tokenUrl}")
    private String tokenUrl;
    /**
     * API Key
     */
    @Value("${baidu_API_Key}")
    private String clientId;
    /**
     * Secret Key
     */
    @Value("${baidu_Secret_Key}")
    private String clientSecret;

    /**
     * accessToken
     */
    private static String accessToken = null;

    private AccessTokenUtil(){}

    /**
     * 获取AccessToken
     * @return
     */
    public String getAccessToken(){
        if (StringUtils.isEmpty(accessToken)){
            //获取Token
            synchronized(AccessTokenUtil.class){
                accessToken = getToken(clientId, clientSecret);
                if (StringUtils.isEmpty(accessToken)){
                    // todo 获取token失败，通知管理员
                }
                return accessToken;
            }
        }else{
            //返回Token
            return accessToken;
        }
    }

    /**
     * 获取AccessToken
     * @param clientId
     * @param clientSecret
     * @return
     */
    private String getToken(String clientId, String clientSecret){
        try {
            String getAccessTokenUrl = tokenUrl + "?"
                                       // 1. grant_type为固定参数
                                       + "grant_type=client_credentials"
                                       // 2. 官网获取的 API Key
                                       + "&client_id=" + clientId
                                       // 3. 官网获取的 Secret Key
                                       + "&client_secret=" + clientSecret;
            URL url = new URL(getAccessTokenUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            Map<String, String> parse = (Map<String, String>) JSONObject.parse(result);
            String access_token = parse.get("access_token");
            return access_token;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

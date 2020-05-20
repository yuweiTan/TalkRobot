package com.cyw.TalkRobot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyw.TalkRobot.entity.PO.response.ActionListPO;
import com.cyw.TalkRobot.entity.PO.response.ResponseListPO;
import com.cyw.TalkRobot.entity.PO.robot.ParamsPO;
import com.cyw.TalkRobot.entity.PO.robot.RequestPO;
import com.cyw.TalkRobot.entity.VO.TalkResultVO;
import com.cyw.TalkRobot.service.TalkService;
import com.cyw.TalkRobot.util.AccessTokenUtil;
import com.cyw.TalkRobot.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * Talk Service
 *
 * @author cyw
 * @date 2020/5/19 16:38
 */
@Service
public class TalkServiceImpl implements TalkService {

    /**
     * 请求URL
     */
    @Value("${baidu_talkUrl}")
    private String talkUrl;

    /**
     * 当前api版本对应协议版本号
     */
    @Value("${baidu_version}")
    private String version;

    /**
     * 机器人ID
     */
    @Value("${baidu_service_id}")
    private String serviceId;

    /**
     * 用户id
     */
    private String userId = "abcdefg123";
    /**
     * session保存机器人的历史会话信息
     */
    private String sessionId = "";

    @Autowired
    private AccessTokenUtil accessTokenUtil;


    /**
     * 用户说的话
     */
    @Override
    public String say(String str) {
        try {
            if (StringUtils.isEmpty(str)){
                str = "你好";
            }
            String post = HttpUtil.post(talkUrl, accessTokenUtil.getAccessToken(), packageParams(str));
            TalkResultVO talkResultVO = JSONObject.parseObject(post, TalkResultVO.class);
            return talkResultVO.getResult().getResponse_list().get(0).getAction_list().get(0).getSay();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 封装用户的对话
     * @param str
     * @return
     */
    private String packageParams(String str) {
        RequestPO requestPO = new RequestPO(userId, str);
        String logId = UUID.randomUUID().toString().replace("-", "");
        ParamsPO paramsPO = new ParamsPO(version, serviceId, logId, sessionId, requestPO);
        return JSONObject.toJSONString(paramsPO);
    }


}

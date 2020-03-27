package com.cyw.TalkRobot.entity.PO.skill;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

/**
 *技能的session信息
 */
@Data
public class BotSessionPO {
    /**
     * 【必需】 会话ID
     */
    private String session_id;
    /**
     * 技能视图数据（意图、词槽解析的历史与最新结果），一般是与交互元素相关但无直接对应关系，需要推演得出的数据。这种数据在此处缓存，可节约计算开销
     */
    private Object bot_views;
    /**
     * 对话状态数据，供本地化对话管理模块（如DMKit）使用
     */
    private Object dialog_state;
    /**
     * 历史交互序列，即历史 request/response 序列，序列的每一个元素称作一次交互（interaction），随交互进行而交替插入，格式与上述不断增长直到发生清空操作
     */
    private List<InteractionsPO> interactions;

    public BotSessionPO() {
    }

    public BotSessionPO(String session_id) {
        this.session_id = session_id;
    }

    public String toJsonString(){
        return JSONObject.toJSONString(this);
    }
}

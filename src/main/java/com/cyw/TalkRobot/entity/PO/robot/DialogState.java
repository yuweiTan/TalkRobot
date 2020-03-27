package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.Map;

/**
 * 机器人对话状态
 */
@Data
public class DialogState {
    /**
     * 技能的对话状态key为技能ID，value为技能的对话状态数据。具体数据格式后续发布
     */
    private Map<String, Object> skill_states;
    /**
     * (JSON)希望在多技能对话过程中贯穿的全局性上下文. 这里预留了一个key用于控制各技能的session记忆。详见【请求参数详细说明】
     */
    private String contexts;
}

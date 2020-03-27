package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * 本轮应答列表
 */
@Data
public class ResponseListPO {
    /**
     * 状态码，0为正常
     */
    private int status;
    /**
     * 错误信息，非零时有效
     */
    private String msg;
    /**
     * 应答来自哪个技能（skill_id）或机器人（service_id），注意有些应答可能是机器人给出的（不来自任何一个技能）
     */
    private String origin;
    /**
     * 动作列表
     */
    private List<ActionListPO> action_list;
    /**
     * 解析的schema，解析意图、词槽结果都从这里面获取
     */
    private SchemaPO schema;
    /**
     * SLU解析结果，之所以是optional，是因为response不一定是由某个技能产生，因此不一定有SLU结果
     */
    private QuResPO qu_res;
}

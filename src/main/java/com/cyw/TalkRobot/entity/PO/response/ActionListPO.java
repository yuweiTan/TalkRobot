package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

/**
 * 动作列表
 */
@Data
public class ActionListPO {
    /**
     * 动作置信度
     */
    private float confidence;
    /**
     * 动作ID
     */
    private String action_id;
    /**
     * 应答话术
     */
    private String say;
    /**
     * (json)	用户自定义应答，如果action_type为event，对应事件定义在此处。详见【响应参数详细说明】
     */
    private String custom_reply;
    /**
     * 动作类型
     */
    private String type;
    /**
     * 澄清与引导(type=clarify/guide/faqguide)时有效，表达澄清或引导的详细信息。
     */
    private RefineDetailPO refine_detail;
}

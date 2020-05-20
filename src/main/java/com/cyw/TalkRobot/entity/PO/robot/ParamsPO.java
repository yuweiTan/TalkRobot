package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.List;

/**
 * 对话PO
 */
@Data
public class ParamsPO {

    /**
     * 【必需】固定值2.0。当前api版本对应协议版本号为2.0
     */
    private String version;
    /**
     * 【必需 2选1】机器人ID，service_id 与skill_ids不能同时缺失，至少一个有值。
     */
    private String service_id;
    /**
     * 【必需 2选1】技能ID列表。我们允许开发者指定调起哪些技能。这个列表是有序的——排在越前面的技能，优先级越高。技能优先级体现在response的排序上。具体排序规则参见【应答参数说明】
     */
    private List<String> skill_ids;
    /**
     * 【必需】开发者需要在客户端生成的唯一id，用来定位请求，响应中会返回该字段。对话中每轮请求都需要一个log_id
     */
    private String log_id;
    /**
     * 【必需 选1】	session保存机器人的历史会话信息，由机器人创建，客户端从上轮应答中取出并直接传递，不需要了解其内容。如果为空，则表示清空session（开发者判断用户意图已经切换且下一轮会话不需要继承上一轮会话中的词槽信息时可以把session置空，从而进行新一轮的会话）。
     *     session字段内容较多，开发者可以通过传送session_id的方式节约传输流量。具体操作方式见【请求参数详细说明】
     */
    private String session_id;
    private SessionPO session;

    /**
     * 【必需】机器人对话状态
     */
    private DialogState dialog_state;

    /**
     * 【必需】本轮请求体
     */
    private RequestPO request;

    public ParamsPO() {}

    public ParamsPO(String version, String service_id, String log_id, String session_id, RequestPO request) {
        this.version = version;
        this.service_id = service_id;
        this.log_id = log_id;
        this.session_id = session_id;
        this.request = request;
    }

    public ParamsPO(String version, String service_id, String log_id, SessionPO session, RequestPO request) {
        this.version = version;
        this.service_id = service_id;
        this.log_id = log_id;
        this.session = session;
        this.request = request;
    }
}

package com.cyw.TalkRobot.entity.PO.skill;

import lombok.Data;

/**
 * 对话PO【必需】
 */
@Data
public class ParamsPO {

    /**
     * 固定值2.0。当前api版本对应协议版本号为2.0
     */
    private String version;

    /**
     * 开发者需要在客户端生成的唯一id，用来定位请求，响应中会返回该字段。对话中每轮请求都需要一个log_id
     */
    private String bot_id;

    /**
     * 技能唯一标识，在『我的技能』的技能列表中的技能ID，详情见【请求参数详细说明】
     */
    private String log_id;
    /**
     * 本轮请求体
     */
    private RequestPO request;

    /**
     * 技能的session信息，由技能创建，client从上轮应答中取出并直接传递，不需要了解其内容。如果为空，则表示清空session
     * （开发者判断用户意图已经切换且下一轮会话不需要继承上一轮会话中的词槽信息时可以把session置空，从而进行新一轮的会话）。
     * 传参时可只传session_id。以下为bot_session内部格式，仅供参考了解
     */
    private String bot_session;

    public ParamsPO() {}

    public ParamsPO(String version, String bot_id, String log_id, RequestPO request, String bot_session) {
        this.version = version;
        this.bot_id = bot_id;
        this.log_id = log_id;
        this.request = request;
        this.bot_session = bot_session;
    }
}

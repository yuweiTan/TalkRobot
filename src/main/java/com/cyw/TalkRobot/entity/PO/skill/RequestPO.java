package com.cyw.TalkRobot.entity.PO.skill;

import lombok.Data;

/**
 * 本轮请求体
 */
@Data
public class RequestPO {
    /**
     * 【必需】与技能对话的用户id（如果客户端是用户未登录状态情况下对话的，也需要尽量通过其他标识（比如设备id）来唯一区分用户），方便今后在平台的日志分析模块定位分析问题、从用户维度统计分析相关对话情况。
     */
    private String user_id;
    /**
     * 【必需】本轮请求query（用户说的话）
     */
    private String query;
    /**
     * 【必需】本轮请求query的附加信息
     */
    private QueryInfoPO query_info;
    /**
     * 【必需】系统自动发现不置信意图/词槽，并据此主动发起澄清确认的频率。取值范围：0(关闭)、1(低频)、2(高频)。取值越高代表技能对不置信意图/词槽的敏感度就越高，建议值为1
     */
    private int bernard_level;
    /**
     * (json)用于在多轮中实现多选一的对话效果。详情见【请求参数详细说明】
     */
    private String client_session;
    /**
     * (json)干预信息。详情见【请求参数详细说明】
     */
    private UpdatasPO updates;
    /**
     * 【必需】本轮请求query（用户说的话）
     */
    private HyperParamsPO hyper_params;

    public RequestPO() {}

    public RequestPO(String user_id, String query, QueryInfoPO query_info, int bernard_level, HyperParamsPO hyper_params) {
        this.user_id = user_id;
        this.query = query;
        this.query_info = query_info;
        this.bernard_level = bernard_level;
        this.hyper_params = hyper_params;
    }
}

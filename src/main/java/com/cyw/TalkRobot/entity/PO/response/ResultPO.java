package com.cyw.TalkRobot.entity.PO.response;

import com.cyw.TalkRobot.entity.PO.robot.SessionPO;
import com.cyw.TalkRobot.entity.PO.robot.DialogState;

import lombok.Data;

import java.util.List;

/**
 * 返回数据内容
 */
@Data
public class ResultPO {
    /**
     * =2.0，当前api版本对应协议版本号为2.0，固定值
     */
    private String version;
    /**
     * 机器人ID，同请求参数
     */
    private String service_id;
    /**
     * 日志唯一ID（用户与机器人的一问一答为一次interaction，其中用户每说一次对应有一个log_id）
     */
    private String log_id;
    /**
     * 【json】本轮对话后更新的session信息，具体为哪个字段，与请求数据有关，详情见【请求参数详细说明】
     */
    private String session_id;
    private SessionPO session;

    /**
     * 对话状态数据，外提以方便session托管。
     */
    private DialogState dialog_state;
    /**
     * 为本轮请求+应答之组合，生成的id
     */
    private String interaction_id;
    /**
     *	interaction生成的时间（以interaction_id的生成时间为准）。格式：YYYY-MM-DD HH:MM:SS.fff （24小时制，精确到毫秒）
     */
    private String timestamp;
    /**
     *	本轮应答列表。由于请求接口支持请求多个技能，因此这里可能有多个应答。应答列表是有序的，其第一个元素是最为推荐采用的一个应答。决定应答列表顺序的规则详见【响应参数详细说明】
     */
    private List<ResponseListPO> response_list;
}

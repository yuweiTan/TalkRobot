package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 历史会话信息
 */
@Data
public class SessionPO {

    /**
     * 机器人ID，标明该session由哪个机器人产生。
     */
    private String service_id;
    /**
     * 【必需】session本身的ID，客户端可以使用session_id代替session，节约传输流量。
      */
    private String session_id;
    /**
     * 【必需】这里存储与当前对话相关的所有技能的session。key为技能ID，value为技能的session（同【UNIT对话API文档】中的bot_session)。
     */
    private Map<String, Object> skill_sessions;
    /**
     * 【必需】历史交互序列，即历史 request/response_list 序列，序列的每一个元素称作一次交互（interaction），随交互进行而交替插入，格式与上述不断增长直到发生清空操作。
     */
    private List<InteractionsPO> interactions;
}

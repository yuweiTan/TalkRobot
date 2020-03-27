package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.List;

/**
 * 本轮请求query的附加信息
 */
@Data
public class QueryInfoPO {
    /**
     * 【必需】请求信息类型，取值范围："TEXT","EVENT"。详情见【请求参数详细说明】。
     */
    private String type;
    /**
     * 请求信息来源，可选值："ASR","KEYBOARD"。ASR为语音输入，KEYBOARD为键盘文本输入。针对ASR输入，UNIT平台内置了纠错机制，会尝试解决语音输入中的一些常见错误
     */
    private String source;
    /**
     * 可选,请求信息来源若为ASR，该字段为ASR候选信息。（如果调用百度语音的API会有该信息，UNIT会参考该候选信息做综合判断处理。）
     */
    private List<AsrCandidatesPO> asr_candidates;

    public QueryInfoPO() {
    }

    public QueryInfoPO(String type) {
        this.type = type;
    }
}

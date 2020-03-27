package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

/**
 * ASR候选信息
 */
@Data
public class AsrCandidatesPO {
    /**
     * 可选,语音输入候选文本
     */
    private String text;
    /**
     * 可选,语音输入候选置信度
     */
    private float confidence;
}

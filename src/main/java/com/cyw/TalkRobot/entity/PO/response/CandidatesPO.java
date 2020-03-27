package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 意图候选项
 */
@Data
public class CandidatesPO {
    /**
     * 解析结果整体的（综合意图和词槽）置信度，如果返回结果中无该字段，请重新训练后尝试。
     */
    private double confidence;
    /**
     * 候选项意图名称
     */
    private String intent;
    /**
     * 候选项意图置信度
     */
    private String intent_confidence;
    /**
     * 意图是否需要澄清
     */
    private boolean intent_need_clarify;
    /**
     * 词槽列表
     */
    private List<SlotsPO> slots;
    /**
     * 来自哪个qu策略（smart-qu对应对话模板，ml-qu对应对话样本学习）
     */
    private String from_who;
    /**
     * query匹配信息
     */
    private String match_info;
    /**
     * 候选项附加信息
     */
    private Map<String, String> extra_info;

}

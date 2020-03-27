package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * 解析的schema，解析意图、词槽结果都从这里面获取
 */
@Data
public class SchemaPO {
    /**
     * schema的总体置信度
     */
    private double confidence;
    /**
     * 意图
     */
    private String intent;
    /**
     * 意图置信度
     */
    private double intent_confidence;
    /**
     * 词槽列表
     */
    private List<SlotsPO> slots;


}

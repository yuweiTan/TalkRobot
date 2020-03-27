package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.List;

/**
 * 影响UNIT内部行为的超参数
 */
@Data
public class HyperParamsPO {
    /**
     * 技能自动发现不置信意图/词槽，并据此主动发起澄清确认的频率。取值范围：0(关闭)、1(低频)、2(高频)。取值越高代表技能对不置信意图/词槽的敏感度就越高，默认值=1
     */
    private float bernard_level;
    /**
     * slu运行级别，值域1，2，3，默认值=1
     */
    private int slu_level;
    /**
     * slu阈值，值域0.0~1.0，值越高表示召回的阈值越高，避免误召回，默认值=0.5。
     */
    private double slu_threshold;
    /**
     * 用于限定slu的解析范围，只在打上了指定tag的意图、或问答对的范围内执行slu
     */
    private List<String> slu_tags;
    /**
     * 针对特定词槽启用『动态词典』机制，key为词槽名（如user_xxx），value为针对该词槽启用的动态词典id（可以同时启用多个动态词典）。
     */
    private List<String> dynamic_slots;
}

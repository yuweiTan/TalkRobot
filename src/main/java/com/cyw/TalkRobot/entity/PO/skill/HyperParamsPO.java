package com.cyw.TalkRobot.entity.PO.skill;

import lombok.Data;

import java.util.List;

/**
 * 影响UNIT内部行为的超参数
 */
@Data
public class HyperParamsPO {
    /**
     * slu阈值，默认值为0.5，值域0.0~1.0，值越高表示召回的阈值越高，避免误召回
     */
    private float slu_threshold;
    /**
     * slu运行级别，值域1，2，3，默认值=1
     */
    private int slu_level;
    /**
     * 用于限定slu的解析范围，只在打上了指定tag的意图、或问答对的范围内执行slu
     */
    private List<String> slu_tags;
    /**
     * 针对特定词槽启用『动态词典』机制，key为词槽名（如user_xxx），value为针对该词槽启用的动态词典id（可以同时启用多个动态词典）。
     */
    private List<String> dynamic_slots;
    /**
     * 取非零值时，对话技能将只运行对话理解部分，以便更好地与外置的对话管理技术（如DMKit、Taskflow）配合。问答技能和遗留在旧版对话技能中的FAQ问答能力，不受此参数影响。
     */
    private int slu_only;

}

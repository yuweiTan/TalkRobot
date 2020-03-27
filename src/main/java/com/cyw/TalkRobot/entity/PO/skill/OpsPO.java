package com.cyw.TalkRobot.entity.PO.skill;

import lombok.Data;

/**
 * 干预操作集
 */
@Data
public class OpsPO {
    /**
     * 操作方式，当前只能取『DEFINE』，表明定义一个对象
     */
    private String op;
    /**
     * 操作针对的对象，可选值为意图（INTENT）、词槽（SLOT）
     */
    private String target;
    /**
     * 操作对象的值
     */
    private Object value;
}

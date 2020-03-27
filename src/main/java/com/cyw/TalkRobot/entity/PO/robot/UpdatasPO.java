package com.cyw.TalkRobot.entity.PO.robot;

import lombok.Data;

import java.util.List;

/**
 * 干预信息
 */
@Data
public class UpdatasPO {
    /**
     * 干预方式，当前只能取『DEFINE』，表明抛弃系统解析结果，转而由updates字段来定义
     */
    private String type;
    /**
     * 干预操作集。
     */
    private List<OpsPO> ops;
}

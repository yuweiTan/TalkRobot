package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.Map;

/**
 * 选项列表
 */
@Data
public class OptionPO {
    /**
     * 选项文字
     */
    private String option;
    /**
     * 选项细节信息。详见【响应参数详细说明】
     */
    private Map<String, String> info;
}

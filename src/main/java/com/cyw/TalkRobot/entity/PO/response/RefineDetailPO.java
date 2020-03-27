package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * 澄清与引导(type=clarify/guide/faqguide)时有效，表达澄清或引导的详细信息。
 */
@Data
public class RefineDetailPO {
    /**
     * 交互形式
     */
    private String interact;
    /**
     * 选项列表。
     */
    private List<OptionPO> option_list;
    /**
     * 动作类型为clarify时有值，表明起因
     */
    private String clarify_reason;
}

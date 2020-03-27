package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * query的词法分析结果
 */
@Data
public class LexicalAnalysisPO {
    /**
     * 词汇(含命名实体)
     */
    private String term;
    /**
     * 重要性权重
     */
    private double weight;
    /**
     * 词性或专名类别
     */
    private String type;
    /**
     * 命名实体兼属的所有专名类别
     */
    private List<String> etypes;
    /**
     * 构成词汇的基本词
     */
    private List<String> basic_word;
}

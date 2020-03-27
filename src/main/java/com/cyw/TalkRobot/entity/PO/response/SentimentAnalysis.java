package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

/**
 * query的情感分析结果
 */
@Data
public class SentimentAnalysis {
    /**
     * 情感标签(取值范围："0"、"1"、"2"，分别代表：负向情感、无情感、正向情感)
     */
    private String label;
    /**
     * 置信度，取值范围0-1
     */
    private double pval;

}

package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * SLU解析结果，之所以是optional，是因为response不一定是由某个技能产生，因此不一定有SLU结果
 */
@Data
public class QuResPO {
    /**
     * query结果时间戳
     */
    private int timestamp;
    /**
     * query结果状态
     */
    private int status;
    /**
     * 原始query
     */
    private String raw_query;
    /**
     * 意图候选项
     */
    private List<CandidatesPO> candidates;
    /**
     * (json)	最终qu结果，内部格式同result.response.qu_res.candidates[]
     */
    private String qu_res_chosen;
    /**
     * query的词法分析结果
     */
    private List<LexicalAnalysisPO> lexical_analysis;
    /**
     * query的情感分析结果
     */
    private SentimentAnalysis sentiment_analysis;

}

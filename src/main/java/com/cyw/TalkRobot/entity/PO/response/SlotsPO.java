package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

import java.util.List;

/**
 * 词槽列表
 */
@Data
public class SlotsPO {
    /**
     * 词槽置信度
     */
    private double confidence;
    /**
     * 起始位置
     */
    private int begin;
    /**
     * 长度
     */
    private int length;
    /**
     * 词槽值
     */
    private String original_word;
    /**
     * 归一化词槽值
     */
    private String normalized_word;
    /**
     * 词槽值细化类型[保留字段]
     */
    private String word_type;
    /**
     * 词槽名称
     */
    private String name;
    /**
     * 词槽是在第几轮对话中引入的
     */
    private int session_offset;
    /**
     * 词槽引入的方式
     */
    private String merge_method;
    /**
     * 子词槽list，内部结构同正常词槽。
     */
    private List<SlotsPO> sub_slots;


    /**
     * 词槽是否需要澄清
     */
    private boolean need_clarify;
    /**
     * 父词槽index，非子词槽，取值-1
     */
    private int father_idx;
}

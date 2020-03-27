package com.cyw.TalkRobot.Enums;

/**
 * 情感标签
 */
public enum EmotionTagsEnum {
    NegativeEmotion("0", "负向情感"),
    NoEmotion("1", "无情感"),
    PositiveEmotion("2", "正向情感");
    private String key;
    private String value;

    EmotionTagsEnum() {
    }

    EmotionTagsEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

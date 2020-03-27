package com.cyw.TalkRobot.Enums;

/**
 * 输入来源
 */
public enum SourceEnum {
    ASR("ASR", "语音输入"),
    KEYBOARD("KEYBOARD", "键盘文本输入");

    private String key;
    private String value;
    SourceEnum(){}

    SourceEnum(String key, String value){
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

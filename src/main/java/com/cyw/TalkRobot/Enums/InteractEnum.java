package com.cyw.TalkRobot.Enums;

/**
 * 交互形式
 */
public enum InteractEnum {
    select("select", "给出选项供选择"),
    ask("ask", "提问"),
    selectandask("selectandask", "给出选项并且追加提问");

    private String key;
    private String value;

    InteractEnum() {
    }

    InteractEnum(String key, String value) {
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

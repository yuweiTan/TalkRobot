package com.cyw.TalkRobot.Enums;

/**
 * 动作类型
 */
public enum ActionEnum {
    clarify("clarify", "澄清"),
    satisfy("satisfy", "满足"),
    guide("guide", "引导到对话意图"),
    faqguide("faqguide", "引导到问答意图"),
    understood("understood", "理解达成"),   //注：内部使用
    failure("failure", "理解失败"),
    chat("chat", "聊天话术"),
    event("event", "触发事件"); //在答复型对话回应中选择了"执行函数"，将返回event类型的action

    private String key;
    private String value;

    ActionEnum() {
    }

    ActionEnum(String key, String value) {
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

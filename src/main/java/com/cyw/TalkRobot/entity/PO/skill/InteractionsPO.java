package com.cyw.TalkRobot.entity.PO.skill;

import lombok.Data;

/**
 * 历史交互序列
 */
@Data
public class InteractionsPO {
    /**
     * 第 i 次交互的唯一标识
     */
    private String interaction_id;
    /**
     * 第 i 次交互的 request，结构参考【请求参数说明】中的request
     */
    private Object request;
    /**
     * 第 i 次交互的 response，结构参考【响应参数说明】中的response
     */
    private Object response;

}

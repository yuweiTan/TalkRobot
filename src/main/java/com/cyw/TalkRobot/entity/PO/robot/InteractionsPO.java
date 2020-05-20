package com.cyw.TalkRobot.entity.PO.robot;

import com.cyw.TalkRobot.entity.PO.response.ResponseListPO;
import lombok.Data;

import java.util.List;

/**
 * 历史交互序列
 */
@Data
public class InteractionsPO {
    /**
     * 【必需】第 i 次交互的唯一标识。
     */
    private String interaction_id;
    /**
     * 【必需】interaction生成的时间（以interaction_id的生成时间为准）。格式：YYYY-MM-DD HH:MM:SS.fff （24小时制，精确到毫秒）
     */
    private String timestamp;
    /**
     * 【必需】第 i 次交互的 request，结构参考【请求参数说明】中的request
     */
    private Object request;
    /**
     * 【必需】第 i 次交互的 response列表，结构参考【应答参数说明】中的response_list
     */
    private List<ResponseListPO> response_list;
}

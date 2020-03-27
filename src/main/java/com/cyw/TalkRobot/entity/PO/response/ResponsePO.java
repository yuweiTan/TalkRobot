package com.cyw.TalkRobot.entity.PO.response;

import lombok.Data;

/**
 * 响应参数
 */
@Data
public class ResponsePO {
    /**
     * 错误码，为0时表示成功
     */
    private int error_code;
    /**
     * 错误信息，errno!= 0 时存在
     */
    private String error_msg;
    /**
     * 返回数据对象，当errno为0时有效
     */
    private ResultPO result;
}

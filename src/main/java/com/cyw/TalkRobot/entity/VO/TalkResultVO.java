package com.cyw.TalkRobot.entity.VO;

import com.cyw.TalkRobot.entity.PO.response.ResultPO;
import lombok.Data;

/**
 * 返回结果
 *
 * @author cyw
 * @date 2020/5/20 12:41
 */
@Data
public class TalkResultVO {
    private ResultPO result;
    private int error_code;
}

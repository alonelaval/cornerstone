package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.MessageRuleType;
import com.alonelaval.cornerstone.entity.constants.MessageSendChannel;
import com.alonelaval.cornerstone.entity.constants.MessageSendType;
import com.alonelaval.cornerstone.entity.constants.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysMessageRuleModel implements Model {
    /**
     * 消息模版
     */
    private String msgContentTemplate;
    /**
     * 机构ID
     */
    private Integer orgId;
    /***
     * 消息规则类型
     */
    private MessageRuleType ruleType;
    /**
     * 规则名称
     */
    private String ruleName;
    /**
     * 消息发送渠道
     */
    private MessageSendChannel msgSendChannel;
    /**
     * 定时值
     */
    private String sendCrontab;
    /**
     * 哪个机构的员工添加的
     */
    private Integer employeId;
    /***
     * 发送时间
     */
    private LocalDateTime sendTime;
    /**
     * 备注
     */
    private String remark;
    /***
     * 消息发送类型
     */
    private MessageSendType sendType;
    /***
     * 消息类型
     */
    private MessageType messageType;


}

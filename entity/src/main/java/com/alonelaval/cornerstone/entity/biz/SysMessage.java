package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.MessageSendChannel;
import com.alonelaval.cornerstone.entity.constants.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_sys_message")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class SysMessage extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;
    @Column(name = "rule_type")
    private MessageSendChannel ruleType;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "send_time")
    private LocalDateTime sendTime;
    @Column(name = "msg_send_channel")
    @Enumerated
    private MessageSendChannel msgSendChannel;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "receiver_user_id")
    private Integer receiverUserId;
    @Column(name = "message_content")
    private String messageContent;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "receiver_user_name")
    private String receiverUserName;
    @Column(name = "receiver_phone")
    private String receiverPhone;
    @Column(name = "rule_id")
    private Integer ruleId;
    @Column(name = "message_type")
    @Enumerated
    private MessageType messageType;


    @Override
    @Transient
    protected String getEntityId() {
        return this.messageId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.messageId = Integer.parseInt(id);
    }
}

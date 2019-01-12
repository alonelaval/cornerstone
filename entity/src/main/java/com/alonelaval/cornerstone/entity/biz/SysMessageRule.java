package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.*;
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
@Table(name = "tb_sys_message_rule")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class SysMessageRule extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "omr_id")
    private Integer omrId;
    @Column(name = "audit_user_id")
    private Integer auditUserId;
    @Column(name = "msg_content_template")
    private String msgContentTemplate;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "audit_user_name")
    private String auditUserName;
    @Column(name = "platform_audit_state")
    @Enumerated
    private AuditState platformAuditState;
    @Column(name = "rule_type")
    @Enumerated
    private MessageRuleType ruleType;
    @Column(name = "add_user_Id")
    private Integer addUserId;
    @Column(name = "rule_name")
    private String ruleName;
    @Column(name = "msg_send_channel")
    @Enumerated
    private MessageSendChannel msgSendChannel;
    @Column(name = "send_crontab")
    private String sendCrontab;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "send_time")
    private LocalDateTime sendTime;
    @Column(name = "add_user_name")
    private String addUserName;
    @Column(name = "remark")
    private String remark;
    @Column(name = "send_type")
    @Enumerated
    private MessageSendType sendType;
    @Column(name = "message_type")
    @Enumerated
    private MessageType messageType;

    @Override
    @Transient
    protected String getEntityId() {
        return this.omrId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.omrId = Integer.parseInt(id);
    }
}

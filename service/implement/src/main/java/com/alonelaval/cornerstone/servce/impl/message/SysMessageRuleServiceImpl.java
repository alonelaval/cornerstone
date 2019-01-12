package com.alonelaval.cornerstone.servce.impl.message;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ExceptionUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.org.SysMessageRuleDao;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.SysMessageRule;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.AuditState;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.SysMessageRuleModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.message.SysMessageRuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("sysMessageRuleService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class SysMessageRuleServiceImpl extends AbstractBaseService<SysMessageRule,Integer> implements SysMessageRuleService {
    @Autowired
    SysMessageRuleDao sysMessageRuleDao;


    @Override
    public SysMessageRule add(Model model) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        SysMessageRuleModel sysMessageRuleModel = (SysMessageRuleModel) model;

        SysMessageRule sysMessageRule = SysMessageRule.builder()
                .addUserId(userAdapter.getUser().getUserId())
                .addUserName(userAdapter.getUser().getUserRealName())
                .remark(sysMessageRuleModel.getRemark())
                .messageType(sysMessageRuleModel.getMessageType())
                .sendCrontab(sysMessageRuleModel.getSendCrontab())
                .sendTime(sysMessageRuleModel.getSendTime())
                .sendType(sysMessageRuleModel.getSendType())
                .msgContentTemplate(sysMessageRuleModel.getMsgContentTemplate())
                .msgSendChannel(sysMessageRuleModel.getMsgSendChannel())
                .ruleName(sysMessageRuleModel.getRuleName())
                .ruleType(sysMessageRuleModel.getRuleType())
                .platformAuditState(AuditState.WAIT_AUDIT)
                .build();

        if(userAdapter.getLoginType().equals(RoleOwnType.ORG_ROLE)){
            sysMessageRule.setOrgId(userAdapter.getOrg().get().getOrgId());
            sysMessageRule.setOrgName(userAdapter.getOrg().get().getOrgName());
            sysMessageRule.setEmployeId(userAdapter.getOrgEmployee().getEmployeId());
        }
        SetEntityProperties.getInstance().setProperties(sysMessageRule);

        return this.add(sysMessageRule);
    }

    @Override
    protected IBaseDao<SysMessageRule,Integer> getBaseDao() {
        return sysMessageRuleDao;
    }

    @Override
    public SysMessageRule auditRule(Integer id, AuditState auditState) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        Optional<SysMessageRule> sysMessageRuleOptional = sysMessageRuleDao.findById(id);
        if(sysMessageRuleOptional.isPresent()){
            sysMessageRuleOptional.get().setPlatformAuditState(auditState);
            sysMessageRuleOptional.get().setAuditUserId(userAdapter.getUser().getUserId());
            sysMessageRuleOptional.get().setAuditUserName(userAdapter.getUser().getUserRealName());
            return  this.update(sysMessageRuleOptional.get());
        }
        ExceptionUtil.throwServiceException(ExceptionType.OP_NOT_ALLOWED);
        return null;
    }
}

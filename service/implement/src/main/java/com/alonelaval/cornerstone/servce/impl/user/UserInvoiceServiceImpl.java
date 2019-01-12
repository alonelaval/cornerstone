package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.page.Page;
import com.alonelaval.common.util.AssertUtil;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserInvoiceDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.QUserInvoice;
import com.alonelaval.cornerstone.entity.biz.UserInvoice;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.InvoiceModel;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserInvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userInvoiceService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserInvoiceServiceImpl extends AbstractBaseService<UserInvoice,Integer> implements UserInvoiceService {
    @Autowired
    UserInvoiceDao userInvoiceDao;
    

    @Override
    protected IBaseDao<UserInvoice,Integer> getBaseDao() {
        return userInvoiceDao;
    }

    @Override
    public UserInvoice update(Model model, Integer id) throws Exception {
        InvoiceModel invoiceModel = (InvoiceModel) model;
        UserAdapter userAdapter  = (UserAdapter) UserContextHolder.getInstance().getUser();

        if(Optional.ofNullable(id).isPresent()){

            Optional<UserInvoice> userInvoiceOptional = findById(id);
            if(userInvoiceOptional.isPresent()){
                UserInvoice userInvoice = userInvoiceOptional.get();
                AssertUtil.isTrue(!userAdapter.getUser().getUserId().equals(userInvoice.getUserId()),
                        new ServiceException(ExceptionType.NOT_AUTH.value(),ExceptionType.NOT_AUTH.desc()));
                userInvoice.setBankAccount(invoiceModel.getBankAccount());
                userInvoice.setTaxNo(invoiceModel.getTaxNo());
                userInvoice.setBankName(invoiceModel.getBankName());
                userInvoice.setCompanyPhone(invoiceModel.getCompanyPhone());
                userInvoice.setInvoiceTitle(invoiceModel.getInvoiceTitle());
                userInvoice.setInvoiceType(invoiceModel.getInvoiceType());
                userInvoice.setIssuedType(invoiceModel.getIssuedType());
                userInvoice.setRegAddress(invoiceModel.getRegAddress());

                return  update(userInvoice);
            }
        }
        return null;
    }

    @Override
    public Page<UserInvoice> findByModelAndPage(Model model, Page<UserInvoice> page) throws Exception {
        InvoiceModel invoiceModel = (InvoiceModel) model;
        WhereBuilder builder = WhereBuilder.build();
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        builder.in(QUserInvoice.userInvoice.state,State.ENABLED,State.DISABLED);
        builder.and(QUserInvoice.userInvoice.userId,userAdapter.getUser().getUserId());
        builder.and(QUserInvoice.userInvoice.issuedType,invoiceModel.getIssuedType());
        builder.and(QUserInvoice.userInvoice.invoiceType,invoiceModel.getInvoiceType());
        builder.startWith(QUserInvoice.userInvoice.invoiceTitle,invoiceModel.getInvoiceTitle());

        return userInvoiceDao.findAllByPredicateAndPage(builder.predicate(),page);
    }
    @Override
    public UserInvoice add(Model model1) throws Exception {
        InvoiceModel model = (InvoiceModel) model1;
        UserAdapter userAdapter  = (UserAdapter) UserContextHolder.getInstance().getUser();

        UserInvoice userInvoice =
                UserInvoice.builder().invoiceTitle(model.getInvoiceTitle())
                        .invoiceType(model.getInvoiceType())
                        .bankAccount(model.getBankAccount())
                        .bankName(model.getBankName())
                        .companyPhone(model.getCompanyPhone())
                        .issuedType(model.getIssuedType())
                        .regAddress(model.getRegAddress())
                        .taxNo(model.getTaxNo())
                        .userId(userAdapter.getUser().getUserId())
                        .userName(userAdapter.getUser().getUserRealName())
                        .build();

        SetEntityProperties.getInstance().setProperties(userInvoice);

        return addUserInvoice(userInvoice);
    }



    @Override
    public void deleteByInvoiceIds(List<Integer> invoiceIds) throws Exception {
        if(Optional.ofNullable(invoiceIds).isPresent()){
            userInvoiceDao.updateState(State.DELETE,invoiceIds);
        }
    }
    @Override
    public List<UserInvoice> findInvoicesByUserId(Integer userId) throws Exception {
        return Optional.ofNullable(userInvoiceDao.findAllByUserId(userId)).orElse(Collections.emptyList());
    }
}

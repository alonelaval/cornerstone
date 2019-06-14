package com.alonelaval.cornerstone.servce.impl.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.inter.user.UserAddresseeDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.QUserAddressee;
import com.alonelaval.cornerstone.entity.biz.UserAddressee;
import com.alonelaval.cornerstone.entity.biz.UserAddresseeTag;
import com.alonelaval.cornerstone.entity.common.SetEntityProperties;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.entity.model.UserAddresseeModel;
import com.alonelaval.cornerstone.entity.model.UserAddresseeTagModel;
import com.alonelaval.cornerstone.servce.impl.AbstractBaseService;
import com.alonelaval.cornerstone.service.user.UserAddresseeService;
import com.alonelaval.cornerstone.service.user.UserAddresseeTagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
@Service("userAddresseeService")
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class UserAddresseeServiceImpl extends AbstractBaseService<UserAddressee,Integer> implements UserAddresseeService {
    @Autowired
    UserAddresseeDao userAddresseeDao;
    @Autowired
    UserAddresseeTagService userAddresseeTagService;
    

    @Override
    protected IBaseDao<UserAddressee,Integer> getBaseDao() {
        return userAddresseeDao;
    }

    @Override
    public UserAddressee addUserAddress(UserAddresseeModel userAddresseeModel) throws Exception {
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        UserAddressee userAddressee = UserAddressee.builder()
                .address(userAddresseeModel.getAddress())
                .city(userAddresseeModel.getCity())
                .county(userAddresseeModel.getCounty())
                .province(userAddresseeModel.getProvince())
                .userId(userAdapter.getUser().getUserId())
                .userName(userAdapter.getUser().getUserRealName())
                .receiveUserName(userAddresseeModel.getReceiveUserName())
                .receiveUserPhone(userAddresseeModel.getReceiveUserPhone())
                .build();

        SetEntityProperties.getInstance().setProperties(userAddressee);
        this.add(userAddressee);
        userAddressee.setTags(addAddresseeTags(userAddresseeModel.getTags(),userAddressee.getAddresseeId(),userAdapter));
        return userAddressee;
    }

    @Override
    public List<UserAddressee> findAllByUserId(Integer userId) throws Exception {
        return Optional.ofNullable(userAddresseeDao.findAllByUserId(userId)).orElse(Collections.emptyList());
    }


    private List<UserAddresseeTag> addAddresseeTags(List<UserAddresseeTagModel> tagModels,Integer addresseeId,UserAdapter userAdapter) throws Exception {
        List<UserAddresseeTag> tags = newArrayList();
        if(Optional.ofNullable(tagModels).isPresent()){
                tagModels.stream().forEach((tagModel)->{
                    UserAddresseeTag tag = UserAddresseeTag.builder().tagName(tagModel.getTagName())
                            .addresseeId(addresseeId)
                            .userId(userAdapter.getUser().getUserId())
                            .userName(userAdapter.getUser().getUserRealName())
                            .build();
                    SetEntityProperties.getInstance().setProperties(tag);
                    tags.add(tag);
            });
            return  userAddresseeTagService.saveAll(tags);
        }
        return  tags;
    }


    @Override
    public Page<UserAddressee> findByModelAndPage(Model model, Page<UserAddressee> page) throws Exception {
        UserAddresseeModel userAddresseeModel = (UserAddresseeModel) model;
        WhereBuilder builder = WhereBuilder.build();
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();

        builder.in(QUserAddressee.userAddressee.state,State.ENABLED,State.DISABLED);
        builder.and(QUserAddressee.userAddressee.userId,userAdapter.getUser().getUserId());

        builder.and(QUserAddressee.userAddressee.province,userAddresseeModel.getProvince());
        builder.and(QUserAddressee.userAddressee.city,userAddresseeModel.getCity());
        builder.and(QUserAddressee.userAddressee.county,userAddresseeModel.getCounty());
        builder.startWith(QUserAddressee.userAddressee.receiveUserName,userAddresseeModel.getReceiveUserName());
        builder.startWith(QUserAddressee.userAddressee.receiveUserPhone,userAddresseeModel.getReceiveUserPhone());



        return userAddresseeDao.findAllByPredicateAndPage(builder.predicate(),page);
    }


    @Override
    public UserAddressee update(Model model, Integer addresseeId) throws Exception {
        UserAddresseeModel userAddresseeModel = (UserAddresseeModel) model;
        UserAdapter userAdapter = (UserAdapter) UserContextHolder.getInstance().getUser();
        Optional<UserAddressee> optionalUserAddressee = findById(addresseeId);

        if(optionalUserAddressee.isPresent()) {
            UserAddressee userAddressee = optionalUserAddressee.get();

            userAddressee.setAddress(userAddresseeModel.getAddress());
            userAddressee.setCity(userAddresseeModel.getCity());
            userAddressee.setCounty(userAddresseeModel.getCounty());
            userAddressee.setProvince(userAddresseeModel.getProvince());
            userAddressee.setReceiveUserName(userAddresseeModel.getReceiveUserName());
            userAddressee.setReceiveUserPhone(userAddresseeModel.getReceiveUserPhone());

            userAddresseeTagService.deleteAllByAddresseeId(addresseeId);

            userAddressee.setTags(addAddresseeTags(userAddresseeModel.getTags(), userAddressee.getAddresseeId(), userAdapter));

            return userAddressee;
        }
        return  null;
    }
}

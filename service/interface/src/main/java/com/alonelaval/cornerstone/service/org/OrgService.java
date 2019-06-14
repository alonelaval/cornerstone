package com.alonelaval.cornerstone.service.org;

import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.model.OrgModel;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface OrgService  extends IBaseService<Org,Integer> {
    default Org addOrg(Org org) throws Exception{
        return  this.add(org);
    }
    boolean orgNameIsExist(String orgName)throws  Exception;

    Org addOrg(OrgModel orgModel,User user)throws  Exception;

    Org addOrgOrSubOrg(OrgModel orgModel,List<String> resourceFiles)throws  Exception;
//    UserAdapter orgRegister(OrgModel orgModel, List<String> resourceFiles, User user)throws  Exception;
}
package com.alonelaval.cornerstone.service.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.model.OrgModel;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.service.IBaseService;

/**
 * @author huawei
 * @create 2018-07-08
 **/
public interface UserService  extends IBaseService<User,Integer> {
    default User addUser(User user) throws Exception{ return  this.add(user);}
    boolean usernameIsExist(String username)throws  Exception;
    boolean phoneIsExist(String phone)throws  Exception;

    User loginByPhone(String phone,String password)throws  Exception;

    /***
     * 用户找回密码，登录名称，手机号
     * @param loginName
     * @param phone
     * @param newPassword
     * @param phoneCode
     * @return
     * @throws Exception
     */
    User findPassword(String loginName,String phone,String newPassword,String phoneCode)throws Exception;


    /***
     * 机构注册
     * @param orgName
     * @param password
     * @param phone
     * @param phoneCode
     * @return
     * @throws Exception
     */
    UserAdapter orgRegister(String orgName, String password, String phone, String phoneCode)throws Exception;

    /**
     * 机构注册
     * @param userModel
     * @param orgModel
     * @return
     * @throws Exception
     */
    UserAdapter orgRegister(UserModel userModel, OrgModel orgModel)throws  Exception;
    /**
     * 机构用户注册
     * @param orgId
     * @param password
     * @param phone
     * @param phoneCode
     * @return
     * @throws Exception
     */
    UserAdapter orgUserRegister(Integer orgId, String password, String phone, String phoneCode)throws Exception;

    /***
     * 添加用户，如果用户已经注册过了，验证用户手机验证码，如果没有注册，那么就注册
     * @param userModel
     * @return
     * @throws Exception
     */
    User userRegister(UserModel userModel)throws  Exception;

    /**
     * C端用户注册
     * @param password
     * @param phone
     * @param phoneCode
     * @return
     * @throws Exception
     */
    UserAdapter userRegister(String password, String phone, String phoneCode)throws  Exception;

    Page<User> findUser(UserModel userModel,Page page)throws  Exception;

    User findByPhone(String phone)throws Exception;

    User createUser(String phone,String password)throws  Exception;

    User createUser(UserModel userModel)throws  Exception;

//    /**
//     * 禁用用户
//     * @param userIds
//     * @throws Exception
//     */
//    void disableUsers(Integer ... userIds)throws  Exception;
//
//    /***
//     * 启用用户
//     * @param userIds
//     * @throws Exception
//     */
//    void enableUsers(Integer ... userIds)throws  Exception;
//
//    /***
//     * 删除用户
//     * @param userIds
//     * @throws Exception
//     */
//    void deleteUsers(Integer ... userIds)throws  Exception;


}

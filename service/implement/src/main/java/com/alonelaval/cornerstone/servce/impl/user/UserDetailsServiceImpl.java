//package com.alonelaval.cornerstone.servce.impl.user;
//
//import DaoException;
//import User;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//
///**
// * @author huawei
// * @create 2018-07-13
// **/
//@Service("userDetailService")
//@Slf4j
//public class UserDetailsServiceImpl extends  UserServiceImpl implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        log.info(username);
//        User user  = null;
//        try {
//            String orgId = RequestContextHolder.currentRequestAttributes().getAttribute("orgId",RequestAttributes.SCOPE_REQUEST).toString();
//            log.info(orgId);
//            user = userDao.findByLoginName(username);
//            if(user == null){
//                user = userDao.findByPhone(username);
//            }
//            if(user == null ){
//                user= userDao.findByEmail(username);
//            }
//        } catch (DaoException e) {
//            log.error("查找登录用户名出错！",e);
//        }
//        if(user == null ){
//            throw new UsernameNotFoundException(String.format("用户名  {0} 不存在!", new Object[]{username}));
//        }
//
//        return new org.springframework.security.core.userdetails.User(username,user.getLoginPassword(),null);
//    }
//}

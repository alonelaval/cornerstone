package com.alonelaval.common.context;


import com.alonelaval.common.exception.ServiceException;
import com.alonelaval.common.exception.UserNotLoginException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 * @author huawei
 * @create 2018-07-29
 **/
public class UserContextHolder{

    private UserContextHolder(){}
    public static UserContextHolder getInstance(){
        return UserContextHolderInner.holder;
    }

    public Authentication authentication(){
        return  SecurityContextHolder.getContext().getAuthentication();
    }

    public User getUser() throws ServiceException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(isAnonymous()){
            throw  new UserNotLoginException("用户未登录！");
        }

        return (User) authentication.getPrincipal();
    }


    public boolean isAnonymous(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && !(authentication instanceof  AnonymousAuthenticationToken) ) {
            return false;
        }
        return  true;
    }
    public void setAuthentication(Authentication authentication){
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private static class UserContextHolderInner{
       private static   final UserContextHolder holder = new UserContextHolder();
    }
}

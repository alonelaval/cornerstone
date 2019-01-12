package com.alonelaval.cornerstone.service.user;

import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author huawei
 * @create 2018-07-13
 **/
public interface CustomUserDetailsService {
    UserDetails loadUserByUsernameAndOrgId(String username, String password, Integer orgId, RoleOwnType loginType , PasswordEncoder passwordEncoder) throws AuthenticationException;
}

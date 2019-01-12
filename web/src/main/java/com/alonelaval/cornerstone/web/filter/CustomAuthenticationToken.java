package com.alonelaval.cornerstone.web.filter;

import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author huawei
 * @create 2018-07-13
 **/
public class CustomAuthenticationToken  extends UsernamePasswordAuthenticationToken {
    @Setter @Getter
    private Integer orgId;
    @Setter @Getter
    private RoleOwnType loginType;

    public CustomAuthenticationToken(Object principal, Object credentials, Integer orgId,RoleOwnType loginType) {
        super(principal, credentials);
        this.orgId = orgId;
        this.loginType = loginType;
//        super.setAuthenticated(f);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, Integer orgId,RoleOwnType loginType,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.orgId = orgId;
        this.loginType = loginType;
    }
}

package com.alonelaval.cornerstone.entity.base;


import com.alonelaval.cornerstone.entity.biz.*;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author huawei
 * @create 2018-07-13
 **/
//@Slf4j
public  class UserAdapter extends org.springframework.security.core.userdetails.User {
    private User user;
    private Optional<Org> org;
    private OrgEmployee orgEmployee;
    private RoleOwnType loginType;
    private Optional<PlatformShopkeeper> platformShopkeeper;

    public UserAdapter(String username, String password, Collection<? extends GrantedAuthority> authorities,RoleOwnType loginType) {
        super(username, password, authorities);
        this.loginType = loginType;
    }

    public UserAdapter(User user, Org org1, OrgEmployee orgEmployee, RoleOwnType loginType) {
        super(user.getLoginName(),user.getLoginPassword(),
                user.getRoles().stream().map(Role::getRoleCode).map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
        this.user =user;
        this.org =Optional.ofNullable(org1);
        this.orgEmployee = orgEmployee;
        this.loginType = loginType;
        this.platformShopkeeper = Optional.empty();
    }

    public UserAdapter(User user, Org org1, OrgEmployee orgEmployee, RoleOwnType loginType, PlatformShopkeeper platformShopkeeper) {
        super(user.getLoginName(),user.getLoginPassword(),
                user.getRoles().stream().map(Role::getRoleCode).map(SimpleGrantedAuthority::new).collect(Collectors.toList())
        );
        this.user =user;
        this.org =Optional.ofNullable(org1);
        this.orgEmployee = orgEmployee;
        this.loginType = loginType;
        this.platformShopkeeper = Optional.ofNullable(platformShopkeeper);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Optional<Org> getOrg() {
        return org;
    }

    public void setOrg(Optional<Org> org) {
        this.org = org;
    }

    public OrgEmployee getOrgEmployee() {
        return orgEmployee;
    }

    public Optional<PlatformShopkeeper> getPlatformShopkeeper() {
        return platformShopkeeper;
    }

    public void setPlatformShopkeeper(Optional<PlatformShopkeeper> platformShopkeeper) {
        this.platformShopkeeper = platformShopkeeper;
    }

    public void setOrgEmployee(OrgEmployee orgEmployee) {
        this.orgEmployee = orgEmployee;
    }

    public RoleOwnType getLoginType() {
        return loginType;
    }

    public void setLoginType(RoleOwnType loginType) {
        this.loginType = loginType;
    }
}

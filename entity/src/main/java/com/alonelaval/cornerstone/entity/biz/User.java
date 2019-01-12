package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.Gender;
import com.alonelaval.cornerstone.entity.constants.PermissionType;
import com.alonelaval.cornerstone.entity.constants.RegSource;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author huawei
 * @create 2018-07-07
 **/

@Entity
@Table(name = "tb_user")
@Builder(builderMethodName="userBuilder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private  Integer userId;
    @Column(name="login_name")
    private String loginName;
    @Column(name="login_password")
    private String loginPassword;
    @Column(name="phone")
    private String phone;
    @Column(name="user_real_name")
    private String userRealName;
    @Column(name="idcard")
    private String idcard;
    @Column(name="age")
    private Short  age;
    @Column(name="birthday")
    private String birthday;
    @Column(name="gender")
    @Enumerated()
    private Gender gender;
    @Column(name="reg_source")
    @Enumerated(EnumType.ORDINAL)
    private RegSource regSource;
    @Column(name="reg_terminal")
    private String regTerminal;
    @Column(name="province")
    private String province;
    @Column(name="city")
    private String city;
    @Column(name="county")
    private String county;
    @Column(name="address")
    private String address;
    @Column(name="email")
    private String email;
    @Column(name="icon")
    private String icon;

    @Column(name="consume_count")
    private  Integer consumeCount;

    @Transient
    private Integer currentOrgId;



    @Override
    protected String getEntityId() {
        return this.userId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.userId = Integer.parseInt(id);
    }

    @Transient
    private List<Role> roles;

    @Transient
    private final List<AbstractBasePermission> uriPermissions=new ArrayList<>();

    @Transient
    private final List<AbstractBasePermission> servicePermissions = new ArrayList<>();
    @Transient
    private final  List<AbstractBasePermission> permissions = new ArrayList<>();

    public void setPermissions(List<? extends AbstractBasePermission> basePermissions){
        this.permissions.addAll(basePermissions);
        if(basePermissions != null){
            for(AbstractBasePermission permission : basePermissions) {
                if (permission.getType().equals(PermissionType.API) || permission.getType().equals(PermissionType.MENU)) {
                    uriPermissions.add(permission);
                } else if (permission.getType().equals(PermissionType.SERVICE)) {
                    servicePermissions.add(permission);
                }
            }
        }
    }
}

package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_user_addressee")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserAddressee extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressee_id")
    private Integer addresseeId;
    @Basic
    @Column(name = "province")
    private String province;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "county")
    private String county;

    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "user_id")
    private Integer userId;

    @Basic
    @Column(name = "user_name")
    private String userName;

    @Basic
    @Column(name = "receive_user_name")
    private String receiveUserName;

    @Basic
    @Column(name = "receive_user_phone")
    private String receiveUserPhone;


    @Transient
    public List<UserAddresseeTag> tags;

    @Override
    @Transient
    protected String getEntityId() {
        return this.addresseeId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.addresseeId = Integer.parseInt(id);
    }
}

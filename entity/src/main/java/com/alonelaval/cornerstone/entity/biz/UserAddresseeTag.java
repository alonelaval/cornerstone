package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_user_addressee_tag")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserAddresseeTag extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;


    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "tag_name")
    private String tagName;
    @Column(name = "addressee_id")
    private Integer addresseeId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.tagId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.tagId = Integer.parseInt(id);
    }
}

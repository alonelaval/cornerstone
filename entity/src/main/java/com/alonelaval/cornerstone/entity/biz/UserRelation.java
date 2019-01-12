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
@Table(name = "tb_user_relation")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserRelation extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "relation_id")
    private Integer relationId;

    @Column(name = "relation_user_id")
    private Integer relationUserId;
    @Column(name = "relation_type")
    private Byte relationType;
    @Column(name = "current_user_id")
    private Integer currentUserId;

    @Override
    @Transient
    protected String getEntityId() {
        return this.relationId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.relationId = Integer.parseInt(id);
    }
}

package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.alonelaval.cornerstone.entity.constants.EvaluateLikedType;
import com.alonelaval.cornerstone.entity.constants.EvaluateType;
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
@Table(name = "tb_user_evaluate")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class UserEvaluate extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluate_id")
    private Integer evaluateId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "liked")
    @Enumerated
    private EvaluateLikedType liked;
    @Column(name = "evaluate_type")
    @Enumerated
    private EvaluateType evaluateType;
    @Column(name = "org_name")
    private String orgName;
    @Column(name = "evaluate_subject")
    private Integer evaluateSubject;
    @Column(name = "org_id")
    private Integer orgId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "evaluate_content")
    private String evaluateContent;

    @Override
    @Transient
    protected String getEntityId() {
        return this.evaluateId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.evaluateId = Integer.parseInt(id);
    }
}

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
@Table(name = "tb_org_employee_resource")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class OrgEmployeeResource extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oer_id")
    private Integer oerId;



    @Column(name = "resource_path")
    private String resourcePath;
    @Column(name = "resource_type")
    private Byte resourceType;
    @Column(name = "employe_id")
    private Integer employeId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "org_id")
    private Integer orgId;





    @Override
    @Transient
    protected String getEntityId() {
        return this.oerId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.oerId = Integer.parseInt(id);
    }
}


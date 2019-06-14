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
@Table(name = "tb_secret_key")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class SecretKey extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key_id")
    private Integer keyId;
    @Column(name = "key_value")
    private String keyValue;


    @Override
    @Transient
    protected String getEntityId() {
        return this.keyId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.keyId = Integer.parseInt(id);
    }
}

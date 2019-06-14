package com.alonelaval.cornerstone.entity.base;


import com.alonelaval.common.entity.IEnum;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-07
 **/
//@Data

@MappedSuperclass
@Data
public abstract class AbstractEntity implements IEntity, Serializable {


    private static Logger logger = LoggerFactory.getLogger(AbstractEntity.class);
    @Column(name="state")
    protected State state;
    @Column(name="create_time")
    protected LocalDateTime createTime;
    @Column(name="last_update_time")
    protected LocalDateTime lastUpdateTime;

//    @Transient
//    private String id;

//    @Value("${security.id.secret:12345678}")
//    @Transient
//    private String idSecret;


    @Override
    @Transient
    public String getId(){
//        System.out.println(getEntityId());
//        System.out.println(idSecret);
//            //  CryptoUtils.encDES(getEntityId(),securityKeyForId.getBytes());
//            return IDSecurityUtils.encId(getEntityId(),idSecret);
        return  this.getEntityId();
    }
//    @Override
//    public void setId(String id){
//            //new String(CryptoUtils.decDES(id,securityKeyForId.getBytes()));
////            this.id = IDSecurityUtils.decId(id,idSecret);
////            this.setEntityId(this.id);
//        this.setEntityId(id);
//    }

    @Transient
    protected abstract String getEntityId();

    protected abstract void setEntityId(String id);
    @Override
    public IEnum getState() {
        return state;
    }
    @Override
    public void setState(IEnum state) {
        this.state = (State) state;
    }
//    @Override
//    public IEnum getState() {
//        return this.state;
//    }
//    @Override
////    @Column(name="create_time")
//    public LocalDateTime getCreateTime() {
//        return createTime;
//    }
//    @Override
//    public void setCreateTime(LocalDateTime createTime) {
//        this.createTime = createTime;
//    }
//    @Override
////    @Column(name="last_update_time")
//    public LocalDateTime getLastUpdateTime() {
//        return lastUpdateTime;
//    }
//    @Override
//    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
//        this.lastUpdateTime = lastUpdateTime;
//    }


}
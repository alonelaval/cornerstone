package com.alonelaval.cornerstone.entity.common;

import com.alonelaval.cornerstone.entity.base.IEntity;
import com.alonelaval.cornerstone.entity.constants.State;

import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-29
 **/
public class SetEntityProperties {

    private  SetEntityProperties(){}

    public static  SetEntityProperties getInstance(){
        return  SetEntityPropertiesHolder.PROPERTIES;
    }
    static  final  class  SetEntityPropertiesHolder{
        private static  final  SetEntityProperties  PROPERTIES = new SetEntityProperties();
    }

    public void setProperties(IEntity entity){
        entity.setState(State.ENABLED);
        entity.setCreateTime(LocalDateTime.now());
        entity.setLastUpdateTime(LocalDateTime.now());
    }

}

package com.alonelaval.cornerstone.entity.base;


import com.alonelaval.common.entity.IEnum;

import java.time.LocalDateTime;

/**
 * @author
 * @create 2018-07-07
 **/
public interface IEntity {

//    void setId(String id);

    String getId();

    IEnum getState();
    void setState(IEnum state);
    LocalDateTime getCreateTime();
    void setCreateTime(LocalDateTime localDate);

    LocalDateTime getLastUpdateTime();

    void setLastUpdateTime(LocalDateTime localDate);
}

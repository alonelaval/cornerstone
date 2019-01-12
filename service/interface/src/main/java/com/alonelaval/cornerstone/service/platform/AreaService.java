package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.entity.biz.Area;
import com.alonelaval.cornerstone.service.IBaseService;


/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface AreaService  extends IBaseService<Area,Integer> {
    default Area addArea(Area area) throws Exception{
    	return this.add(area);
    }

}
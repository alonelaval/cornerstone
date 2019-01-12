package com.alonelaval.cornerstone.service.platform;

import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.entity.biz.SysPermission;
import com.alonelaval.cornerstone.service.IBaseService;

import java.util.List;

/**
 * @author huawei
 * @create 2018-07-08
 * create by python
 **/
public interface SysPermissionService  extends IBaseService<SysPermission,Integer> {
    default void addSysPermission(SysPermission sysPermission) throws Exception{
   }

    List<SysPermission> findAllByPermissionIdIn(List<Integer> ids)throws Exception;

}
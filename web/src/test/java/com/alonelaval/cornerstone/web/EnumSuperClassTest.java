package com.alonelaval.cornerstone.web;

import com.alonelaval.common.entity.IEnum;
import com.alonelaval.cornerstone.entity.constants.JobType;

import java.io.Serializable;

/**
 * @author huawei
 * @create 2018-07-28
 **/
public class EnumSuperClassTest implements  Serializable {

    public static void main(String[] args) {

        //测试是否实现了父类
        boolean re1= Object.class.isAssignableFrom(EnumSuperClassTest.class);
        //测试是否实现了接口
        boolean re2=Serializable.class.isAssignableFrom(EnumSuperClassTest.class);

        System.out.println("re1:"+re1+" re2:"+re2);
        System.out.println(JobType.class);

        System.out.println(IEnum.class.isAssignableFrom(JobType.class));

    }
}

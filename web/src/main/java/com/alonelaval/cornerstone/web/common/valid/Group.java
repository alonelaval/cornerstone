package com.alonelaval.cornerstone.web.common.valid;

import javax.validation.GroupSequence;

/**
 * @author huawei
 * @create 2018-07-29
 **/
@GroupSequence({FirstValid.class,SecondValid.class})
public interface Group {

}
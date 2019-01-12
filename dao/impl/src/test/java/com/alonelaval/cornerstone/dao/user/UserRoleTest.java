package com.alonelaval.cornerstone.dao.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.user.UserRoleDao;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.user.UserRoleDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author huawei
 * @create 2018-07-14
 **/
@EnableAutoConfiguration
public class UserRoleTest extends ContextAwareTest {

    @Autowired
    UserRoleDao userRoleDao;
    @Test
    public void findUserRoleTest() throws DaoException {
        Integer userId =32;
        Integer orgId =1;
        userRoleDao.findRoleByUserId(32).stream().forEach(u ->{
            System.out.println(u.toString());
        });

        userRoleDao.findRoleByUserIdAndOrgId(32,orgId).stream().forEach(u ->{
            System.out.println(u.toString());
        });
    }
}

package com.alonelaval.cornerstone.dao.platform;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.platform.RoleDao;
import com.alonelaval.cornerstone.entity.biz.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-14
 **/
@Slf4j
@EnableAutoConfiguration
public class RoleDaoTest extends ContextAwareTest {
    @Autowired
    RoleDao roleDao;

    @Test
    public void findTest(){
        List<Integer>  ids =Arrays.asList(new Integer[]{2});

        try {
            Optional<List<Role>> optional = roleDao.findByIds(ids);
            optional.ifPresent(System.out::println);

        } catch (DaoException e) {
            e.printStackTrace();
        }


    }
}

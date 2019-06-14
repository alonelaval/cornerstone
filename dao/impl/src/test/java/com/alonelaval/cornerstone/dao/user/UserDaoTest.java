package com.alonelaval.cornerstone.dao.user;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.user.UserDao;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.State;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * @author huawei
 * @create 2018-07-08
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DaoApplication.class)
//@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.alonelaval.cornerstone.dao.repository")
//@SpringBootApplication(scanBasePackages="com.alonelaval")
//@EntityScan("com.alonelaval.cornerstone.entity")
//@Slf4j
@EnableAutoConfiguration
public class UserDaoTest  extends ContextAwareTest {
    @Autowired
    UserDao userDao;
    @Test
    public void providesFindOneWithOptional() throws DaoException {
        User user = User.userBuilder().userId(111).loginName("11").phone("111").loginPassword("11").build();
        user.setState(State.DELETE);
        user = userDao.addEntity(user);

        String userId  = user.getId();
        user.setUserId(0);
        System.out.println(user.getId());
//        user.setId(userId);
        System.out.println(user.getUserId());
        System.out.println(user.getLastUpdateTime());




        //assertThat(repository.findById(carter.id)).isPresent();
        //assertThat(repository.findById(carter.id + 1)).isEmpty();
    }

}

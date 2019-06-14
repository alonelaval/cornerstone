package com.alonelaval.cornerstone.dao.org.order;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.org.order.OrgOrderDao;
import com.alonelaval.cornerstone.dao.ContextAwareTest;
import com.alonelaval.cornerstone.dao.inter.org.order.OrgOrderDao;
import com.alonelaval.cornerstone.entity.biz.OrgOrder;
import com.alonelaval.cornerstone.entity.constants.IsInvoiced;
import com.alonelaval.cornerstone.entity.constants.State;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDateTime;

/**
 * @author huawei
 * @create 2018-07-09
 **/
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = DaoApplication.class)
//@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class,basePackages = "com.alonelaval.cornerstone.dao.repository")
//@SpringBootApplication(scanBasePackages="com.alonelaval")
//@EntityScan("com.alonelaval.cornerstone.entity")
@Slf4j
@EnableAutoConfiguration
public class OrgOrderDaoTest extends ContextAwareTest {

    @Autowired
    OrgOrderDao orgOrderDao;
    @Test
    public void save() {
        OrgOrder orgOrder = OrgOrder.builder().orderTime(LocalDateTime.now()).orgId(1).orgName("ttt").dealNumber("11").userId(111)
                .remark("111").isInvoiced(IsInvoiced.INVOICED).sellEmployeId(11).sellUserId(11).sellUserName("hua").totalPayAmount(111)
                .phone("11111111").userName("12121").build();
        orgOrder.setLastUpdateTime(LocalDateTime.now());
        orgOrder.setCreateTime(LocalDateTime.now());
        orgOrder.setState(State.DELETE);

        try {
             orgOrderDao.addEntity(orgOrder);
             orgOrderDao.findById(orgOrder.getOrgOrderId());

            System.out.println(orgOrder.getLastUpdateTime());

        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}

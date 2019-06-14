package com.alonelaval.cornerstone.dao.repository.jpa;

import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRepository;
import com.alonelaval.cornerstone.dao.repository.jpa.biz.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * @author huawei
 * @create 2018-07-08
 **/
public class EntityRepositoryTest  extends  ContextAwareTest{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    public void save() {
        System.out.println(entityManager.getMetamodel());
        System.out.println(entityManager.getMetamodel().getEntities());

//        User entity = User.userBuilder().loginName("11").phone("111").loginPassword("11").build();
//        repository.save(entity);
        //verify(repository).save(entity);/**/
//        User user = User.userBuilder().phone("18616205698").build();
////        Example<User> example = Example.of(user);
////        Page<User> page =userRepository.findAllByPage(example,new Page(10));
////        System.out.println(page.getData().toString());
////        System.out.println(page.toString());
////
////
////        WhereBuilder where = new WhereBuilder();
////        QUser user1 = QUser.user;
////        where.and(user1.phone, "18516205698");
////
////        page = userRepository.findAllByPage(where.predicate(),new Page(10));
////
////        System.out.println(page.getData().toString());
////        System.out.println(page.toString());
    }

}

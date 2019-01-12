package com.alonelaval.cornerstone.dao.repository.jpa.base;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/***
 * 添加自定义分页
 * @param <T>
 * @param <ID>
 * @author  huawei
 */
public class BaseRepositoryImpl<T extends AbstractEntity, ID extends Serializable> extends QuerydslJpaRepository<T,ID> implements BaseRepository<T , ID>
{
    private final EntityManager entityManager;
    private final JpaEntityInformation entityInformation;
    private final Class<T> entityClass;
    private String updateStateSql;
    public BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation =entityInformation;
        this.entityClass = this.getDomainClass();
        try {
            this.updateStateSql = new StringBuilder("update ").append(getTableName(entityManager,this.entityClass))
                    .append(" set ").append("state = :state").append(" where ").append(getIdColumnName(entityClass,this.entityInformation.getIdAttribute().getName()))
                    .append(" in ( :ids )")
                    .toString();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();

        }
    }

    @Override
    public Page<T> findAllByPage(Example<T> example, Page page)
    {
        Pageable pageRequest = PageRequest.of(page.getCurrentPage()-1, page.getPageNum(),sortByPage(page));
        org.springframework.data.domain.Page<T> springPage = this.findAll(example, pageRequest);
        return new SpringDataPageAdapter(springPage);
    }
    @Modifying
    @Override
    public void updateState(Integer state,List<ID> ids){

        Query query =this.entityManager.createNativeQuery(updateStateSql);
        query.setParameter("state",state);
        query.setParameter("ids",ids);
        query.executeUpdate();

//        ityInformation.getIdAttribute().getName());
//        System.out.println(this.entityInformation.getEntityName());
//        System.out.println(this.entityInformation.getIdAttribute().getType());
//        System.out.println(this.entityInformation.getJavaType());
//        System.out.println(this.entityManager.getMetamodel().getEntities());
//        System.out.println(this.getDomainClass());
//        System.out.println(this.getTableName(entityManager,this.getDomainClass()));
//        try {
//            System.out.println(this.getIdColumnName(this.getDomainClass(),this.entityInformation.getIdAttribute().getName()));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public Page<T> findAllByPage(Predicate predicate, Page page) {
        Pageable pageRequest = PageRequest.of(page.getCurrentPage()-1, page.getPageNum(),sortByPage(page));
        org.springframework.data.domain.Page<T> springPage = this.findAll(predicate, pageRequest);
        return new SpringDataPageAdapter(springPage);
    }

    public String getIdColumnName(Class<T> entityClass,String fieldName) throws NoSuchFieldException {
        Field field = entityClass.getDeclaredField(fieldName);
        Column column  = field.getAnnotation(Column.class);
        return column.name();
    }
    /**
     * Returns the table name for a given entity type in the {@link EntityManager}.
     * @param em
     * @param entityClass
     * @return
     */
    public String getTableName(EntityManager em, Class<T> entityClass) {
        /*
         * Check if the specified class is present in the metamodel.
         * Throws IllegalArgumentException if not.
         */
        Metamodel meta = em.getMetamodel();
        EntityType<T> entityType = meta.entity(entityClass);

        //Check whether @Table annotation is present on the class.
        Table t = entityClass.getAnnotation(Table.class);

        String tableName = (t == null)
                ? entityType.getName().toUpperCase()
                : t.name();


        return tableName;
    }

    private Sort sortByPage(Page<T> page){
        Sort sort = Sort.unsorted();
        if(StringUtils.isNotBlank(page.getOrderBy())) {
            Sort.Order order = page.getIsAsc() ? Sort.Order.asc(page.getOrderBy()) : Sort.Order.desc(page.getOrderBy());
            sort = Sort.by(order);
        }
        return  sort;
    }
}

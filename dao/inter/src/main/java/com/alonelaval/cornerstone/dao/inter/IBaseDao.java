package com.alonelaval.cornerstone.dao.inter;

import com.alonelaval.common.exception.DaoException;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.constants.State;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author
 * @create 2018-07-10
 *
 **/
public interface IBaseDao<T,PK> {
    /**
     * 抽象的添加方法
     * @param t
     * @return
     * @throws DaoException
     */
    T addEntity(T t)throws DaoException;

//    Optional<List<T>>  findByIds(List<PK> pks)throws  DaoException;
    /**
     * 更新
     * @param t
     * @return
     * @throws DaoException
     */
    T update(T t)throws  DaoException;

    /**
     * 保存所有
     * @param iterable
     * @return
     * @throws DaoException
     */
    List<T> saveAll(Iterable<T> iterable)throws  DaoException;
    /**
     * 删除
     * @param t
     * @return
     * @throws DaoException
     */
    void delete(T t)throws  DaoException;

    /**
     * 根据ID删除
     * @param id
     * @throws DaoException
     */
    void deleteById(PK id)throws  DaoException;
    /***
     * 获取
     * @param pk
     * @return
     * @throws DaoException
     */
    Optional<T> findById(PK pk)throws  DaoException;

    /**
     * 分页查询
     * @param example
     * @param page
     * @return
     * @throws DaoException
     */
    Page<T> findByExampleAndPage(Example<T> example, Page<T> page)throws DaoException;

    /**
     * 分页查询
     * @param example
     * @param page
     * @return
     * @throws DaoException
     */
    Page<T> findAllByPredicateAndPage(Predicate predicate, Page page)throws DaoException;

    /**
     * 根据条件查找
     * @param predicate
     * @return
     * @throws DaoException
     */
    Optional<T> findOne(Predicate predicate)throws DaoException;
    /***
     * 更新状态
     * @param state
     * @param ids
     * @throws DaoException
     */
    void updateState(State state, List<PK> ids) throws  DaoException;

    /**
     * 查找所有
     * @param predicate
     * @return
     */
    List<T>  listAll(Predicate predicate)throws DaoException;

    /**
     *
     * @param pks
     * @return
     * @throws DaoException
     */
    List<T>  findAllByIds(List<PK> pks)throws  DaoException;
}

package com.alonelaval.cornerstone.dao.impl;

import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.google.common.collect.Lists;
import com.alonelaval.common.exception.DaoException;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.BaseRepository;
import com.alonelaval.cornerstone.entity.base.IEntity;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.State;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-10
 **/

public abstract class AbstractBaseDao<T extends IEntity, PK> implements IBaseDao<T, PK> {

    @Override
    public List<T> saveAll(Iterable<T> iterable) throws DaoException {
        try {

            return getBaseRepository().saveAll(iterable);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public T addEntity(T t) throws DaoException {
        try {
            return getBaseRepository().save(t);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public T update(T t) throws DaoException {
        try {
            return getBaseRepository().save(t);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public List<T>  listAll(Predicate predicate) throws DaoException{
        try {
            return Lists.newArrayList(getBaseRepository().findAll(predicate));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

        @Override
    public void delete(T t) throws DaoException {
        try {
             getBaseRepository().delete(t);
        }catch ( Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }
    @Override
    public void deleteById(PK id) throws DaoException {
        try {
            getBaseRepository().deleteById(id);
        }catch ( Exception e){
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(),e.getMessage(),e);
        }
    }

//    @Override
//    public Optional<List<T>> findByIds(List<PK> pks) throws DaoException {
//        return Optional.ofNullable(getBaseRepository().findAllById(pks));
//    }


    @Override
    public Optional<T> findOne(Predicate predicate) throws DaoException {
        try {
            return getBaseRepository().findOne(predicate);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Optional<T> findById(PK pk) throws DaoException {
        try {
            return getBaseRepository().findById(pk);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Page<T> findByExampleAndPage(Example<T> example, Page<T> page) throws DaoException {
        try {
            return getBaseRepository().findAllByPage(example, page);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public Page<T> findAllByPredicateAndPage(Predicate predicate, Page page) throws DaoException {
        try {
            return getBaseRepository().findAllByPage(predicate, page);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public void updateState(State state, List<PK> ids) throws DaoException {
        try {
            getBaseRepository().updateState(state.value(),ids);
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    @Override
    public List<T> findAllByIds(List<PK> pks) throws DaoException {
        try {
            return Lists.newArrayList(getBaseRepository().findAllById(pks));
        } catch (Exception e) {
            throw new DaoException(ExceptionType.DAO_EXCEPTION.value(), e.getMessage(), e);
        }
    }

    /**
     * 抽象类
     *
     * @return
     */
    protected abstract BaseRepository<T, PK> getBaseRepository();
}

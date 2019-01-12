package com.alonelaval.cornerstone.servce.impl;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.dao.inter.IBaseDao;
import com.alonelaval.cornerstone.dao.repository.jpa.base.WhereBuilder;
import com.alonelaval.cornerstone.entity.constants.State;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.service.IBaseService;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-12
 **/

public abstract class AbstractBaseService<T,PK> implements IBaseService<T,PK> {
    @Transactional(rollbackFor = Exception.class)
    @Override
    public T add(T t) throws Exception {
        return  getBaseDao().addEntity(t);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public T update(T t) throws Exception {
        return getBaseDao().update(t);

    }
    @Override
    public Optional<T> findById(PK id) throws Exception {
        return  getBaseDao().findById(id);
    }

    @Override
    public Page<T> findByModelAndPage(Model model, Page<T> page)throws Exception{

        return  getBaseDao().findAllByPredicateAndPage(WhereBuilder.build().predicate(),page);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disable(List<PK> ids) throws Exception {
        updateState(State.DISABLED,ids);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enable(List<PK> ids) throws Exception {
        updateState(State.ENABLED,ids);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<PK> ids) throws Exception {
//        updateState(State.DELETE,ids);
        if(Optional.ofNullable(ids).isPresent()){
            for(PK id : ids){
                deleteById(id);
            }
        }
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(T t) throws Exception {
        getBaseDao().delete(t);
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(PK id) throws Exception {
        getBaseDao().deleteById(id);
    }

    private void updateState(State state, List<PK> ids)throws  Exception{
        if(Optional.ofNullable(ids).isPresent()){
            getBaseDao().updateState(state,ids);
        }
    }

    @Override
    public List<T> listAll(Model model) throws Exception {

        return getBaseDao().listAll(WhereBuilder.build().predicate());
    }

    @Override
    public List<T> saveAll(Iterable<T> iterable) throws Exception {
        return getBaseDao().saveAll(iterable);
    }

    @Override
    public T update(Model model, PK pk) throws Exception {

        throw  new NotImplementedException("没有实现！");
    }


    @Override
    public T add(Model model) throws Exception {
        throw  new NotImplementedException("没有实现！");
    }

    @Override
    public List<T> findAllByIds(List<PK> pks) throws Exception {
        return getBaseDao().findAllByIds(pks);
    }

    /**
     * 抽象类
     * @return
     */
    protected abstract IBaseDao<T,PK> getBaseDao();
}

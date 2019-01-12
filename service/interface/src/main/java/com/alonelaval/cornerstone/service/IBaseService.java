package com.alonelaval.cornerstone.service;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.model.Model;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

/**
 * @author huawei
 * @create 2018-07-12
 **/
public interface IBaseService<T,PK> {

    /**
     * 抽象的添加方法
     * @param t
     * @return
     * @throws Exception
     */
    T add(T t)throws Exception;
    T add(Model model) throws Exception;
    /**
     * 保存所有
     * @param iterable
     * @return
     * @throws Exception
     */
    List<T> saveAll(Iterable<T> iterable)throws  Exception;

    /**
     * 更新
     * @param t
     * @return
     * @throws Exception
     */
    T update(T t)throws  Exception;

    T update(Model model,PK pk)throws  Exception;
    /**
     * 删除
     * @param t
     * @return
     * @throws Exception
     */
    void delete(T t)throws  Exception;
    /**
     * 删除
     * @param
     * @return
     * @throws Exception
     */
    void deleteById(PK id)throws  Exception;

    /***
     * 获取
     * @param pk
     * @return
     * @throws Exception
     */
    Optional<T> findById(PK pk)throws  Exception;

    List<T> listAll(@Nullable  Model model)throws  Exception;
    /***
     * 分页
     * @param model
     * @param page
     * @return
     * @throws Exception
     */
    Page<T> findByModelAndPage(Model model,Page<T> page)throws Exception;

    /**
     * 禁用
     * @param ids
     * @throws Exception
     */
    void disable(List<PK> ids)throws  Exception;

    /***
     * 启用
     * @param ids
     * @throws Exception
     */
    void enable(List<PK> ids)throws  Exception;

    /***
     * 删除
     * @param ids
     * @throws Exception
     */
    void delete(List<PK> ids)throws  Exception;

    /**
     *
     * @param pks
     * @return
     * @throws Exception
     */
    List<T> findAllByIds(List<PK> pks)throws  Exception;
}

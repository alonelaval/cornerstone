package com.alonelaval.cornerstone.dao.repository.jpa.base;

import com.alonelaval.common.page.Page;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepository<T, ID>,QuerydslPredicateExecutor<T>
{

    Page<T> findAllByPage(Example<T> example, Page page);

    Page<T> findAllByPage(Predicate predicate, Page page);

    @Modifying
    void updateState(Integer state,List<ID> ids);
}

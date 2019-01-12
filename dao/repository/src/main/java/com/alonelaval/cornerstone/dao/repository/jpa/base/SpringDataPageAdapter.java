package com.alonelaval.cornerstone.dao.repository.jpa.base;

import com.alonelaval.common.page.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author  huawei
 * @param <T>
 */
@NoRepositoryBean
public class SpringDataPageAdapter<T> extends Page<T>
{
    public SpringDataPageAdapter(org.springframework.data.domain.Page<T> page)
    {
        super(page.getNumber()+1, page.getSize(), (int)page.getTotalElements());
        setData(page.getContent());
        setTotalCount((int)page.getTotalElements());
        Sort sort = page.getSort();
        if(sort.isSorted()){
            Sort.Order order= sort.iterator().next();
            setOrderBy(order.getProperty());
            setIsAsc(order.isAscending());
        }

    }
}

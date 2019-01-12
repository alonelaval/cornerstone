package com.alonelaval.cornerstone.dao.repository.jpa.base;

import com.alonelaval.common.date.DateTimeUtils;
import com.alonelaval.common.date.TimeUtils;
import com.alonelaval.common.entity.IEnum;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.*;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author huawei
 * @author zhangpeng
 * @create 2018-07-28
 **/
public class WhereBuilder {


    public static WhereBuilder build(){
        return  new WhereBuilder();
    }
    private BooleanBuilder booleanBuilder = new BooleanBuilder();

    public WhereBuilder and(NumberPath path, Integer condition)
    {
        if(condition!=null)
        {
            booleanBuilder.and(path.eq(condition));
        }
        return this;

    }

    public WhereBuilder and(EnumPath path, Enum condition)
    {
        if(condition!=null)
        {
            booleanBuilder.and(path.eq(condition));
        }
        return this;
    }

    public WhereBuilder in(SimplePath path, Enum ... conditions)
    {
        if(conditions!=null )
        {
            booleanBuilder.and(path.in(conditions));
        }
        return this;

    }
    public WhereBuilder in(NumberPath path, List<Integer> conditions)
    {
        if(conditions!=null && !conditions.isEmpty())
        {
            booleanBuilder.and(path.in(conditions));
        }
        return this;

    }

    public WhereBuilder in(SimplePath path, IEnum condition)
    {
        if(condition!=null)
        {
            booleanBuilder.and(path.eq(condition));
        }
        return this;

    }


    public WhereBuilder and(StringPath path, String condition)
    {
        if(StringUtils.isNotBlank(condition))
        {
            booleanBuilder.and(path.eq(condition));
        }
        return this;
    }

    public WhereBuilder startWith(StringPath path, String condition){
        if(StringUtils.isNotBlank(condition))
        {
            booleanBuilder.and(path.startsWith(condition));
        }
        return this;
    }

    public WhereBuilder and(DateTimePath path, Date condition)
    {

        return andBetweenDate(path, condition, condition, true, true);
    }


    public WhereBuilder andBetweenDate(DateTimePath path, Date begin, Date end, boolean isBeginInclusive, boolean isEndInclusive)
    {
        if(end != null)
        {
            if(isEndInclusive)
            {
                booleanBuilder.and(path.loe(TimeUtils.formatTimeEnd(end)));
            }
            else
            {
                booleanBuilder.and(path.lt(TimeUtils.formatTimeEnd(TimeUtils.getFutrueDate(end, -1))));
            }
        }
        if(begin != null)
        {
            if(isBeginInclusive)
            {
                booleanBuilder.and(path.goe(TimeUtils.formatTimeBegin(begin)));
            }
            else
            {
                booleanBuilder.and(path.gt(TimeUtils.formatTimeBegin(TimeUtils.getFutrueDate(begin, 1))));
            }
        }

        return this;
    }

    public WhereBuilder andLocalDateTimeEquals(DatePath path, LocalDateTime date)
    {
        booleanBuilder.and(path.loe(DateTimeUtils.getEndOfDay(date)));
        booleanBuilder.and(path.goe(DateTimeUtils.getStartOfDay(date)));

        return this;
    }
    public WhereBuilder andLocalDateTimeEquals(DateTimePath path, LocalDateTime date)
    {
        booleanBuilder.and(path.loe(DateTimeUtils.getEndOfDay(date)));
        booleanBuilder.and(path.goe(DateTimeUtils.getStartOfDay(date)));

        return this;
    }


    public WhereBuilder andBetweenDate(DatePath path, LocalDate begin, LocalDate end, boolean isBeginInclusive, boolean isEndInclusive)
    {
        if(end != null)
        {
            if(isEndInclusive)
            {
                booleanBuilder.and(path.loe(end));
            }
            else
            {
                booleanBuilder.and(path.lt(end));
            }
        }
        if(begin != null)
        {
            if(isBeginInclusive)
            {
                booleanBuilder.and(path.goe(begin));
            }
            else
            {
                booleanBuilder.and(path.gt(begin));
            }
        }

        return this;
    }
    public WhereBuilder andBetweenDate(DatePath path, LocalDate begin, LocalDate end)
    {
        return  this.andBetweenDate(path,begin,end,true,true);
    }




    public WhereBuilder andBetweenNumber(NumberPath path, Number begin, Number end, boolean isBeginInclusive, boolean isEndInclusive)
    {
        if(end != null)
        {
            if(isEndInclusive)
            {
                booleanBuilder.and(path.loe(end));
            }
            else
            {
                booleanBuilder.and(path.lt(end));
            }
        }
        if(begin != null)
        {
            if(isBeginInclusive)
            {
                booleanBuilder.and(path.goe(begin));
            }
            else
            {
                booleanBuilder.and(path.gt(begin));
            }
        }

        return this;
    }
    public WhereBuilder andBetweenNumber(NumberPath path, Number begin, Number end)
    {
        return  this.andBetweenNumber(path,begin,end,true,true);
    }


    public WhereBuilder andBetweenTime(DateTimePath path, LocalDateTime begin, LocalDateTime end, boolean isBeginInclusive, boolean isEndInclusive)
    {
        if(end != null)
        {
            if(isEndInclusive)
            {
                booleanBuilder.and(path.loe(end));
            }
            else
            {
                booleanBuilder.and(path.lt(end));
            }
        }
        if(begin != null)
        {
            if(isBeginInclusive)
            {
                booleanBuilder.and(path.goe(begin));
            }
            else
            {
                booleanBuilder.and(path.gt(begin));
            }
        }

        return this;
    }




    public WhereBuilder andBetweenTime(DateTimePath path, LocalDateTime begin, LocalDateTime end)
    {
        return  this.andBetweenTime(path,begin,end,true,true);
    }


    public BooleanExpression laterThan(DateTimePath path, LocalDateTime time, boolean isInclusive)
    {
        if(time!=null)
        {
            if(isInclusive)
            {
                return path.goe(time);
            }
            else
            {
                return path.gt(time);
            }
        }
        else
        {
            return null;
        }
    }

    public BooleanExpression earlierThan(DateTimePath path, LocalDateTime time, boolean isInclusive)
    {
        if(time!=null)
        {
            if(isInclusive)
            {
                return path.loe(time);
            }
            else
            {
                return path.lt(time);
            }
        }
        else
        {
            return null;
        }
    }

    public BooleanExpression contains(StringPath path, String condition)
    {
        if(StringUtils.isNotBlank(condition))
        {
            return path.contains(condition);
        }

        return null;
    }

    public WhereBuilder and(BooleanExpression expression)
    {
        if(expression!=null)
        {
            booleanBuilder.and(expression);
        }
        return this;
    }


    public WhereBuilder or(BooleanExpression expression)
    {
        if(expression!=null)
        {
            booleanBuilder.or(expression);
        }
        return this;
    }

    public Predicate predicate()

    {
        return this.booleanBuilder;
    }

}

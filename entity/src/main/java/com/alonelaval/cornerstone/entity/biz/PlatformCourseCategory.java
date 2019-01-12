package com.alonelaval.cornerstone.entity.biz;

import com.alonelaval.cornerstone.entity.base.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huawei
 * @create 2018-07-09
 **/
@Entity
@Table(name = "tb_platform_course_category")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class PlatformCourseCategory extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "category_code")
    private String categoryCode;
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "level")
    private Byte level;

    @Override
    @Transient
    protected String getEntityId() {
        return this.categoryId.toString();
    }

    @Override
    protected void setEntityId(String id) {
        this.categoryId = Integer.parseInt(id);
    }
}

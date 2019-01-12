package com.alonelaval.cornerstone.entity.model;

import com.alonelaval.cornerstone.entity.constants.AllowUserSettingCourseTimeType;
import com.alonelaval.cornerstone.entity.constants.CourseStartType;
import com.alonelaval.cornerstone.entity.constants.CourseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrgCourseModel implements Model {

    private Integer startUserNum;
    private AllowUserSettingCourseTimeType isSettingTime;
    private Date beginDate;
    private String courseName;
    private String classTypeName;

    private CourseStartType startType;
    private Date endDate;
    private Integer secondCategoryId;
    private CourseType courseType;
    private String remark;
    private Integer orgId;
    //对应的班种
    private Integer cctId;

    private List<Integer> placeIds;
    private List<String> resourceFileNames;
    private List<OrgCoursePeriodModel> periodModels;
    private List<OrgCoursePriceModel> priceModels;

}

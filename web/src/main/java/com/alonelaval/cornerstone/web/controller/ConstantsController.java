package com.alonelaval.cornerstone.web.controller;

import com.google.common.collect.Lists;
import com.alonelaval.common.entity.IEnum;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.constants.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huawei
 * @create 2018-10-25
 **/
@Controller()
@RequestMapping("/constants")
public class ConstantsController {

    @GetMapping("/adminDivision")
    @ApiOperation(value="行政区划")
    public Object getAdminDivision(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",AdminDivision.typeName());
        datas.put("data",getData(AdminDivision.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/allowUserSettingCourseTimeType")
    @ApiOperation(value="是否允许用户自定义上课时间")
    public Object getAllowUserSettingCourseTimeType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",AllowUserSettingCourseTimeType.typeName());
        datas.put("data",getData(AllowUserSettingCourseTimeType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/auditState")
    @ApiOperation(value="审核状态")
    public Object getAuditState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",AuditState.typeName());
        datas.put("data",getData(AuditState.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/checkinType")
    @ApiOperation(value="签到的客户端")
    public Object getCheckinType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",CheckinType.typeName());
        datas.put("data",getData(CheckinType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/classArrangeType")
    @ApiOperation(value="排课类型")
    public Object getClassArrangeType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",ClassArrangeType.typeName());
        datas.put("data",getData(ClassArrangeType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/classGradeType")
    @ApiOperation(value="班级类型")
    public Object getClassGradeType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",ClassGradeType.typeName());
        datas.put("data",getData(ClassGradeType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/classState")
    @ApiOperation(value="班级状态")
    public Object getClassState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",ClassState.typeName());
        datas.put("data",getData(ClassState.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/coachType")
    @ApiOperation(value="")
    public Object getCoachType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",CoachType.typeName());
        datas.put("data",getData(CoachType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/courseResourceType")
    @ApiOperation(value="课程资源类型")
    public Object getCourseResourceType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",CourseResourceType.typeName());
        datas.put("data",getData(CourseResourceType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/courseStartType")
    @ApiOperation(value="开班方式")
    public Object getCourseStartType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",CourseStartType.typeName());
        datas.put("data",getData(CourseStartType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/courseType")
    @ApiOperation(value="课程类型")
    public Object getCourseType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",CourseType.typeName());
        datas.put("data",getData(CourseType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/dayType")
    @ApiOperation(value="日期类型")
    public Object getDayType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",DayType.typeName());
        datas.put("data",getData(DayType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/dealType")
    @ApiOperation(value="交易类型")
    public Object getDealType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",DealType.typeName());
        datas.put("data",getData(DealType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/eduBackground")
    @ApiOperation(value="教育背景")
    public Object getEduBackground(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",EduBackground.typeName());
        datas.put("data",getData(EduBackground.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/employeeState")
    @ApiOperation(value="员工状态")
    public Object getEmployeeState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",EmployeeState.typeName());
        datas.put("data",getData(EmployeeState.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/evaluateLikedType")
    @ApiOperation(value="是否喜欢")
    public Object getEvaluateLikedType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",EvaluateLikedType.typeName());
        datas.put("data",getData(EvaluateLikedType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/evaluateType")
    @ApiOperation(value="评价的对象类型")
    public Object getEvaluateType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",EvaluateType.typeName());
        datas.put("data",getData(EvaluateType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/exceptionType")
    @ApiOperation(value="平台异常类型")
    public Object getExceptionType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",ExceptionType.typeName());
        datas.put("data",getData(ExceptionType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/gender")
    @ApiOperation(value="性别")
    public Object getGender(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",Gender.typeName());
        datas.put("data",getData(Gender.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/invoiceIssueType")
    @ApiOperation(value="发票开具类型")
    public Object getInvoiceIssueType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",InvoiceIssueType.typeName());
        datas.put("data",getData(InvoiceIssueType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/invoiceType")
    @ApiOperation(value="")
    public Object getInvoiceType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",InvoiceType.typeName());
        datas.put("data",getData(InvoiceType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/isArrangeClass")
    @ApiOperation(value="是否可以手动排课")
    public Object getIsArrangeClass(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",IsArrangeClass.typeName());
        datas.put("data",getData(IsArrangeClass.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/isCoach")
    @ApiOperation(value="是否是教练")
    public Object getIsCoach(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",IsCoach.typeName());
        datas.put("data",getData(IsCoach.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/isInvoiced")
    @ApiOperation(value="是否开发票")
    public Object getIsInvoiced(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",IsInvoiced.typeName());
        datas.put("data",getData(IsInvoiced.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/jobType")
    @ApiOperation(value="工作类型")
    public Object getJobType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",JobType.typeName());
        datas.put("data",getData(JobType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/messageRuleType")
    @ApiOperation(value="消息规则类型")
    public Object getMessageRuleType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",MessageRuleType.typeName());
        datas.put("data",getData(MessageRuleType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/messageSendChannel")
    @ApiOperation(value="消息发送渠道")
    public Object getMessageSendChannel(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",MessageSendChannel.typeName());
        datas.put("data",getData(MessageSendChannel.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/messageSendType")
    @ApiOperation(value="发送类型")
    public Object getMessageSendType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",MessageSendType.typeName());
        datas.put("data",getData(MessageSendType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/messageType")
    @ApiOperation(value="消息类型")
    public Object getMessageType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",MessageType.typeName());
        datas.put("data",getData(MessageType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/orderState")
    @ApiOperation(value="订单状态")
    public Object getOrderState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",OrderState.typeName());
        datas.put("data",getData(OrderState.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/orderType")
    @ApiOperation(value="订单类型")
    public Object getOrderType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",OrderType.typeName());
        datas.put("data",getData(OrderType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/orgAccountType")
    @ApiOperation(value="机构账号类型")
    public Object getOrgAccountType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",OrgAccountType.typeName());
        datas.put("data",getData(OrgAccountType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/orgResourceType")
    @ApiOperation(value="机构资源类型")
    public Object getOrgResourceType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",OrgResourceType.typeName());
        datas.put("data",getData(OrgResourceType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/orgState")
    @ApiOperation(value="机构状态")
    public Object getOrgState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",OrgState.typeName());
        datas.put("data",getData(OrgState.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/payType")
    @ApiOperation(value="支付方式")
    public Object getPayType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PayType.typeName());
        datas.put("data",getData(PayType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/permissionShow")
    @ApiOperation(value="资源是否显示")
    public Object getPermissionShow(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PermissionShow.typeName());
        datas.put("data",getData(PermissionShow.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/permissionType")
    @ApiOperation(value="资源类型")
    public Object getPermissionType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PermissionType.typeName());
        datas.put("data",getData(PermissionType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/permssionOwnType")
    @ApiOperation(value="资源所属类型")
    public Object getPermssionOwnType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PermssionOwnType.typeName());
        datas.put("data",getData(PermssionOwnType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/placeOwnType")
    @ApiOperation(value="拥有类型")
    public Object getPlaceOwnType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PlaceOwnType.typeName());
        datas.put("data",getData(PlaceOwnType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/platformMessageType")
    @ApiOperation(value="平台短信类型类型")
    public Object getPlatformMessageType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",PlatformMessageType.typeName());
        datas.put("data",getData(PlatformMessageType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/productVersion")
    @ApiOperation(value="系统版本")
    public Object getProductVersion(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",ProductVersion.typeName());
        datas.put("data",getData(ProductVersion.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/regSource")
    @ApiOperation(value="注册来源")
    public Object getRegSource(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",RegSource.typeName());
        datas.put("data",getData(RegSource.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/roleCreateType")
    @ApiOperation(value="角色所属类型")
    public Object getRoleCreateType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",RoleCreateType.typeName());
        datas.put("data",getData(RoleCreateType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/roleOwnType")
    @ApiOperation(value="角色所属类型")
    public Object getRoleOwnType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",RoleOwnType.typeName());
        datas.put("data",getData(RoleOwnType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/state")
    @ApiOperation(value="状态")
    public Object getState(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",State.typeName());
        datas.put("data",getData(State.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/timeType")
    @ApiOperation(value="时间类型")
    public Object getTimeType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",TimeType.typeName());
        datas.put("data",getData(TimeType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/userRelationType")
    @ApiOperation(value="用户关系")
    public Object getUserRelationType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",UserRelationType.typeName());
        datas.put("data",getData(UserRelationType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }

    @GetMapping("/visitType")
    @ApiOperation(value="回访类型")
    public Object getVisitType(){
        Map<String,Object> datas = new HashMap<>(8);
        datas.put("name",VisitType.typeName());
        datas.put("data",getData(VisitType.values()));
        return ResponseEntity.ok().body(JsonResult.builder().data(datas).build());
    }




    private List<Map<String,String>>  getData(IEnum [] enums){
        List<Map<String,String>>  datas = Lists.newArrayList();
        for(IEnum iEnum :enums ){
            Map<String,String> data = new HashMap<>(8);
            data.put("label",iEnum.desc());
            data.put("value",iEnum.value()+"");

            datas.add(data);
        }
        return  datas;
    }
}
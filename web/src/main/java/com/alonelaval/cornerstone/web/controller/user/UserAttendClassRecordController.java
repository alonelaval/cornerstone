package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.UserAttendClassRecord;
import com.alonelaval.cornerstone.entity.model.UserAttendClassRecordModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.user.UserAttendClassRecordService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("user/class/attend")
public class UserAttendClassRecordController extends AbstractController {

    @Autowired
    UserAttendClassRecordService userAttendClassRecordService;

    @PostMapping("add")
    public Object add(@Validated UserAttendClassRecordModel userAttendClassRecordModel) throws Exception {
       return  super.addBasic(userAttendClassRecordModel);
    }

    @PostMapping("update")
    public Object update(@Validated UserAttendClassRecordModel userAttendClassRecordModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(userAttendClassRecordModel,id);
    }

    @PostMapping("list")
    public Object list(UserAttendClassRecordModel model, Page<UserAttendClassRecord> page) throws Exception {
        return  super.listBasic(model,page);
    }

    @PostMapping("/disable")

    public Object disable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.disableBasic(ids);
    }
    @PostMapping("/enable")

    public Object enable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.enableBasic(ids);
    }
    @PostMapping("/delete")

    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
        return  super.deleteBasic(ids);
    }

    @Override
    protected IBaseService getBaseService() {
        return userAttendClassRecordService;
    }

}

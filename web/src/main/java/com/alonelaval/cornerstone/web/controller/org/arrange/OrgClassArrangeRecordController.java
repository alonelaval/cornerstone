package com.alonelaval.cornerstone.web.controller.org.arrange;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgClassArrangeRecord;
import com.alonelaval.cornerstone.entity.model.OrgClassArrangeRecordModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.arrange.OrgClassArrangeRecordService;
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
@RequestMapping("org/class/arrange")
public class OrgClassArrangeRecordController extends AbstractController {

    @Autowired
    OrgClassArrangeRecordService orgClassArrangeRecordService;

    @PostMapping("add")
    public Object add(@Validated OrgClassArrangeRecordModel orgCourseArrangeModel) throws Exception {
       return  super.addBasic(orgCourseArrangeModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgClassArrangeRecordModel orgCourseArrangeModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgCourseArrangeModel,id);
    }

    @PostMapping("list")
    public Object list(OrgClassArrangeRecordModel model, Page<OrgClassArrangeRecord> page) throws Exception {
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
        return orgClassArrangeRecordService;
    }

}

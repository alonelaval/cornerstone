package com.alonelaval.cornerstone.web.controller.org.place;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgPlaceFacility;
import com.alonelaval.cornerstone.entity.model.OrgPlaceFacilityModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.place.OrgPlaceFacilityService;
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
@RequestMapping("org/place/facility")
public class OrgPlaceFacilityController extends AbstractController {

    @Autowired
    OrgPlaceFacilityService orgPlaceFacilityService;

    @PostMapping("add")
    public Object add(@Validated OrgPlaceFacilityModel orgPlaceFacilityModel) throws Exception {
       return  super.addBasic(orgPlaceFacilityModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgPlaceFacilityModel orgPlaceFacilityModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgPlaceFacilityModel,id);
    }

    @PostMapping("list")
    public Object list(OrgPlaceFacilityModel model, Page<OrgPlaceFacility> page) throws Exception {
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
        return orgPlaceFacilityService;
    }

}

package com.alonelaval.cornerstone.web.controller.org.place;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.VmOrgPlace;
import com.alonelaval.cornerstone.entity.model.VmOrgPlaceModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.place.VmOrgPlaceService;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author huawei
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("place")
public class VmOrgPlaceController extends AbstractController {

    @Autowired
    VmOrgPlaceService vmOrgPlaceService;

//    @PostMapping("add")
//    public Object add(@Validated VmOrgPlaceModel vmOrgPlaceModel) throws Exception {
//       return  super.addBasic(vmOrgPlaceModel);
//    }
//
//    @PostMapping("update")
//    public Object update(@Validated VmOrgPlaceModel vmOrgPlaceModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
//        return  super.updateBasic(vmOrgPlaceModel,id);
//    }

    @PostMapping("list")
    public Object list(VmOrgPlaceModel model, Page<VmOrgPlace> page) throws Exception {
        return  super.listBasic(model,page);
    }

//    @PostMapping("/disable")
//    public Object disable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
//        return  super.disableBasic(ids);
//    }
//    @PostMapping("/enable")
//    public Object enable(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
//        return  super.enableBasic(ids);
//    }
//    @PostMapping("/delete")
//    public Object delete(@NotNull(message = "ID不能为空!")  Integer ... ids)throws  Exception{
//        return  super.deleteBasic(ids);
//    }

    @Override
    protected IBaseService getBaseService() {
        return vmOrgPlaceService;
    }

}

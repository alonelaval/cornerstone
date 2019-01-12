package com.alonelaval.cornerstone.web.controller.org;

import com.alonelaval.common.file.FileSaveUtils;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.biz.Org;
import com.alonelaval.cornerstone.entity.model.OrgModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.OrgService;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author huawei
 * @create 2018-07-26
 **/
@Controller()
@RequestMapping("/org")
public class OrgController extends AbstractController {
    @Autowired
    OrgService orgService;
    @Autowired
    ApplicationConfig config;

//    @PostMapping("/updateOrg")
//    public Object updateUser(@Validated UserModel userModel, MultipartFile iconFile, MultipartFile [] orgResouceFiles)throws  Exception{
//        //ResponseEntity.ok().body()
//        System.out.println(iconFile.getOriginalFilename());
//        return ResponseEntity.ok().body(JsonResult.builder().build());
//    }


    @PostMapping("add")
    public Object add(@Validated OrgModel orgModel, MultipartFile iconFile, List<MultipartFile> resourceFiles) throws Exception {

        if(iconFile != null) {
            orgModel.setIconPath(FileSaveUtils.savaFile(iconFile, config.getFilePath()));
        }

        List<String> orgResourceFileNames =newArrayList();
        if(resourceFiles != null ){
            resourceFiles.forEach(file -> orgResourceFileNames.add(FileSaveUtils.savaFile(file,config.getFilePath())));
        }

        return  super.responseData(orgService.addOrgOrSubOrg(orgModel,orgResourceFileNames));
    }

    @PostMapping("update")
    public Object update(@Validated  OrgModel orgModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgModel,id);
    }

    @PostMapping("list")
    public Object list(OrgModel orgModel, Page<Org> page) throws Exception {
        return  super.listBasic(orgModel,page);
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
        return orgService;
    }
}

package com.alonelaval.cornerstone.web.controller.org.employee;

import com.alonelaval.common.file.FileSaveUtils;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgEmployee;
import com.alonelaval.cornerstone.entity.model.CoachModel;
import com.alonelaval.cornerstone.entity.model.OrgEmployeeModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.employee.OrgEmployeeService;
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
 * @create 2018-07-29
 **/
@Controller
@RequestMapping("org/employee")
public class OrgEmployeeController extends AbstractController {

    @Autowired
    OrgEmployeeService orgEmployeeService;
    @Autowired
    ApplicationConfig config;

    @PostMapping("add")
    public Object add(@Validated OrgEmployeeModel orgEmployeeModel) throws Exception {
       return  super.addBasic(orgEmployeeModel);
    }
    @PostMapping("addCoach")
    public Object  addCoach(CoachModel coachModel, MultipartFile iconFile)throws  Exception{

        if(iconFile != null) {
            coachModel.setIconPath(FileSaveUtils.savaFile(iconFile, config.getFilePath()));
        }

        return  responseData(orgEmployeeService.addCoach(coachModel));
    }

    @PostMapping("update")
    public Object update(@Validated OrgEmployeeModel orgEmployeeModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgEmployeeModel,id);
    }

    @PostMapping("/updateInfo")
    public Object updateUser(@Validated OrgEmployeeModel employeeModel, MultipartFile iconFile, List<MultipartFile>  orgResourceFiles)throws  Exception{
        //ResponseEntity.ok().body()
        List<String> resourceFileNames =newArrayList();
        if(orgResourceFiles != null ){
            orgResourceFiles.forEach(file -> resourceFileNames.add(FileSaveUtils.savaFile(file,config.getFilePath())));
        }
        String iconFileName = FileSaveUtils.savaFile(iconFile,config.getFilePath());

        return responseData(orgEmployeeService.updateInfo(employeeModel,resourceFileNames,iconFileName));
    }

    @PostMapping("list")
    public Object list(OrgEmployeeModel model, Page<OrgEmployee> page) throws Exception {
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
        return orgEmployeeService;
    }

}

package com.alonelaval.cornerstone.web.controller.org.course;

import com.alonelaval.common.file.FileSaveUtils;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.controller.AbstractController;
import com.alonelaval.cornerstone.entity.biz.OrgCourse;
import com.alonelaval.cornerstone.entity.model.OrgCourseModel;
import com.alonelaval.cornerstone.service.IBaseService;
import com.alonelaval.cornerstone.service.org.course.OrgCourseService;
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
@RequestMapping("org/course")
public class OrgCourseController extends AbstractController {

    @Autowired
    OrgCourseService orgCourseService;
    @Autowired
    ApplicationConfig config;

    @PostMapping("add")
    public Object add(@Validated OrgCourseModel orgCourseModel,List<MultipartFile> resourceFiles) throws Exception {
        List<String> resourceFileNames =newArrayList();
        if(resourceFiles != null ){
            resourceFiles.forEach(file -> resourceFileNames.add(FileSaveUtils.savaFile(file,config.getFilePath())));
        }
        orgCourseModel.setResourceFileNames(resourceFileNames);
       return  super.addBasic(orgCourseModel);
    }

    @PostMapping("update")
    public Object update(@Validated OrgCourseModel orgCourseModel,@NotNull(message = "ID不能为空！") Integer id) throws Exception {
        return  super.updateBasic(orgCourseModel,id);
    }

    @PostMapping("list")
    public Object list(OrgCourseModel model, Page<OrgCourse> page) throws Exception {
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
        return orgCourseService;
    }

}

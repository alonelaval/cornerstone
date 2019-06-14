package com.alonelaval.cornerstone.web.controller;

import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.model.Model;
import com.alonelaval.cornerstone.service.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author huawei
 * @create 2018-07-29
 **/
@Slf4j
public abstract class AbstractController {

    private IBaseService baseService;

    protected Object addBasic(Model model) throws Exception {
        getBaseService().add(model);
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }


    protected Object updateBasic( Model model , Integer invoiceId) throws Exception {
        getBaseService().update(model,invoiceId);
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }


    protected Object listBasic(Model model, Page page) throws Exception {
        return  ResponseEntity.ok().body(JsonResult.builder()
                .data(getBaseService().findByModelAndPage(model,Optional.ofNullable(page).orElse(Page.build()))).build());
    }


    protected Object disableBasic( Integer ... ids)throws  Exception{
        getBaseService().disable(newArrayList(ids));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }

    protected Object enableBasic( Integer ... ids)throws  Exception{
        getBaseService().enable(newArrayList(ids));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }
    protected Object deleteBasic(Integer ... ids)throws  Exception{
        getBaseService().delete(newArrayList(ids));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }


    protected Object responseData(Object data){
        return ResponseEntity.ok().body(JsonResult.builder().data(data).build());
    }
    protected  Object responseBasic(){
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }

    protected abstract   IBaseService getBaseService();
}

package com.alonelaval.cornerstone.web.controller.user;

import com.alonelaval.common.context.UserContextHolder;
import com.alonelaval.common.page.Page;
import com.alonelaval.cornerstone.entity.base.JsonResult;
import com.alonelaval.cornerstone.entity.base.UserAdapter;
import com.alonelaval.cornerstone.entity.biz.User;
import com.alonelaval.cornerstone.entity.constants.ExceptionType;
import com.alonelaval.cornerstone.entity.constants.RoleOwnType;
import com.alonelaval.cornerstone.entity.model.UserModel;
import com.alonelaval.cornerstone.service.user.UserService;
import com.alonelaval.cornerstone.web.config.ApplicationConfig;
import com.alonelaval.cornerstone.web.filter.CustomAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @author huawei
 * @create 2018-07-15
 **/
@Controller
@RequestMapping("/user")
@Slf4j
@Validated
public class UserContorller {
    @Autowired
    UserService userService;
    @Autowired
    ApplicationConfig config;

    @RequestMapping("/index")
    public String userIndex(Model model) {
        getOrgId().ifPresent(d -> {
            model.addAttribute("orgId", d);
        });
        return "user/index";
    }

    @PostMapping("/findPassword")
    @ResponseBody
    public Object findPassword(@NotBlank(message = "登录名称不能为空！") String loginName,
                               @NotBlank(message = "手机号不能为空！") @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message ="手机号码格式错误！") String phone,
                                @NotBlank(message = "新密码不能为空！") String newPassword,
                               @NotBlank(message = "手机验证码不能为空！") String phoneCode) throws Exception

    {
        userService.findPassword(loginName,phone,newPassword,phoneCode);
        return  JsonResult.builder().data(ExceptionType.SUCCESS.value()).message("密码修改成功！").build();
    }


    @PostMapping("/orgRegister")
    @ResponseBody
    public Object orgRegister(@NotBlank(message = "机构名称不能为空！") String orgName,
                              @NotBlank(message = "用户密码不能为空！") String password,
                              @NotBlank(message = "手机号不能为空！") @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message ="手机号码格式错误！") String phone,
                              @NotBlank(message = "手机验证码不能为空！") String phoneCode) throws Exception {
        UserAdapter userAdapter = userService.orgRegister(orgName,password,phone,phoneCode);

        userAuthentication(userAdapter,RoleOwnType.ORG_ROLE);
        return  userAdapter;
    }

    @PostMapping("/orgUserRegister")
    @ResponseBody
    public Object orgUserRegister(@NotNull(message = "机构编号不能为空！") Integer orgId,
                              @NotBlank(message = "用户密码不能为空！") String password,
                              @NotBlank(message = "手机号不能为空！") @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message ="手机号码格式错误！") String phone,
                              @NotBlank(message = "手机验证码不能为空！") String phoneCode) throws Exception {

        UserAdapter userAdapter = userService.orgUserRegister(orgId,password,phone,phoneCode);
//        userAuthenticationed(userAdapter);
        return  JsonResult.builder().data(ExceptionType.SUCCESS.value()).message("用户注册成功，待审核通过以后，才可以登录！").build();
    }


    @PostMapping("/userRegister")
    @ResponseBody
    public Object userRegister(@NotBlank(message = "用户密码不能为空！") String password,
                                  @NotBlank(message = "手机号不能为空！") @Pattern(regexp = "1[3|4|5|7|8][0-9]\\d{8}",message ="手机号码格式错误！") String phone,
                                  @NotBlank(message = "手机验证码不能为空！") String phoneCode) throws Exception {

        UserAdapter userAdapter = userService.userRegister(password,phone,phoneCode);
        userAuthentication(userAdapter,RoleOwnType.USER_ROLE);
        return  userAdapter;
    }



    @PostMapping("/list")
    public Object list(UserModel userModel, Page<User> page)throws  Exception{
        page = userService.findByModelAndPage(userModel,Optional.ofNullable(page).orElse(Page.build()));
        return ResponseEntity.ok().body(JsonResult.builder().data(page).build());
    }

    @PostMapping("/disable")
    public Object disable(@NotNull(message = "用户ID不能为空!")  Integer ... userIds)throws  Exception{
        userService.disable(newArrayList(userIds));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }
    @PostMapping("/enable")
    public Object enable(@NotNull(message = "用户ID不能为空!")  Integer ... userIds)throws  Exception{
        userService.enable(newArrayList(userIds));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }
    @PostMapping("/delete")
    public Object delete(@NotNull(message = "用户ID不能为空!")  Integer ... userIds)throws  Exception{
        userService.delete(newArrayList(userIds));
        return ResponseEntity.ok().body(JsonResult.builder().build());
    }


    private void userAuthentication(UserAdapter userAdapter,RoleOwnType roleOwnType){
        CustomAuthenticationToken customAuthenticationToken = new CustomAuthenticationToken(userAdapter,userAdapter.getUser().getLoginPassword(),
                userAdapter.getOrg().isPresent()?userAdapter.getOrg().get().getOrgId():null,
                roleOwnType,
                userAdapter.getAuthorities()
        );
        //保存登录状态
        UserContextHolder.getInstance().setAuthentication(customAuthenticationToken);
    }





    @RequestMapping("/index2")
    public String userIndex2(Model model) {
        getOrgId().ifPresent(d -> {
            model.addAttribute("orgId", d);
        });
        return "user/index";
    }


    private Optional<Integer> getOrgId() {
        Authentication auth =  UserContextHolder.getInstance().authentication();
        Integer orgId = null;
        if (auth != null && !auth.getClass().equals(AnonymousAuthenticationToken.class)) {
            UserAdapter user = (UserAdapter) auth.getPrincipal();

            if(user.getOrg().isPresent()){
                orgId = user.getOrg().get().getOrgId();
            }
        }
        return Optional.ofNullable(orgId);
    }


    @PostMapping("/apiLogin")
    @ResponseBody
    public Object apiLogin(String username,String password,Integer orgId ) {
        log.info(username);
        log.info(password);
        return JsonResult.builder();
    }


    @RequestMapping("/login")
    public String login() {
        return "user/login";
    }

}

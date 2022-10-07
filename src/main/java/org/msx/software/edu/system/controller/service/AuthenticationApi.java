//package org.msx.software.edu.system.controller.service;
//
//import com.homat.homatapi.model.dto.PlainTextDto;
//import com.homat.homatapi.model.view.RoleViewModel;
//import com.homat.homatapi.model.view.UserViewModel;
//import com.homat.homatapi.security.jwt.JwtResponse;
//import com.homat.homatapi.service.authentication.PodOAuthService;
//import com.homat.homatapi.service.user.UserManagementService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.AllArgsConstructor;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/auth")
//@CrossOrigin
//@AllArgsConstructor
//public class AuthenticationApi {
//
//    private final PodOAuthService podOAuthService;
//    private final UserManagementService userManagementService;
//
//    @ApiOperation(value = "Get a new token using Pod code",
//            notes = "دریافت یک توکن جدید از پاد با استفاده از کدی که با استفاده از فرم لاگین پاد به دست می آید")
//    @GetMapping("/get-pod-user-token/{pod-code}")
//    public JwtResponse getUserTokenByPodOAuth(
//            @ApiParam(
//                    value = "کدی که توسط استفاده از صفحه لاگین پاد ارسال می گردد",
//                    required = true)
//            @PathVariable(name = "pod-code") String podCode) {
//        UserViewModel user = podOAuthService.getUser(podCode);
//        userManagementService.updateUser(user);
//        return userManagementService.login(user);
//    }
//
//    @ApiOperation(value = "Get a new token using POD business token id",
//            notes = "دریافت یک توکن دسترسی از پاد با استفاده از کد کسب و کار، تمام کسب و کارها می توانند این کد را از صفحه مربوط به کسب کار خود در پاد استخراج کنند")
//    @GetMapping("/get-access-token")
//    public JwtResponse getUserTokenByPodBusinessToken(
//            @ApiParam(
//                    value = "کد کسب و کار، تمام کسب و کارها می توانند این کد را از صفحه مربوط به کسب کار خود در پاد استخراج کنند",
//                    required = true
//            )
//            @RequestParam(name = "token-id") String tokenId) {
//        UserViewModel user = podOAuthService.getUserByBusinessToken(tokenId);
//        userManagementService.updateUser(user);
//        return userManagementService.login(user);
//    }
//
//    @ApiOperation(value = "Refresh token",
//            notes = "یک توکن دسترسی قدیمی را می گیرد، اعتبار سنجی می کند و در صورت معتبر بودن یک توکن دسترسی جدید ایجاد می کند")
//    @GetMapping("/refresh-token")
//    public PlainTextDto refreshToken(
//            @ApiParam(
//                    value = "توکن قدیمی",
//                    required = true
//            )
//            @RequestParam(name = "token") String token) {
//        return new PlainTextDto(userManagementService.refreshToken(token));
//    }
//
//    @ApiOperation(value = "Get all users",
//            notes = "دریافت لیست تمامی کاربران سیستم")
//    @GetMapping("/get/users/all")
//    @PreAuthorize("hasRole('ROLE_USER_MANAGE')")
//    public List<UserViewModel> getAllUsers() {
//        return userManagementService.getAllUsers();
//    }
//
//    @ApiOperation(value = "Get all roles",
//            notes = "دریافت لیست تمامی دسترسی های سیستم")
//    @GetMapping("/get/roles/all")
//    @PreAuthorize("hasRole('ROLE_USER_MANAGE')")
//    public List<RoleViewModel> getAllRoles() {
//        return userManagementService.getAllRoles();
//    }
//
//    @ApiOperation(value = "Change user roles",
//            notes = "تغییر نقش های یک کاربر. توجه داشته باشید که نقش های گذشته کاربر همگی با توجه به اطلاعات ارسالی جدید جابجا می گردد")
//    @PostMapping("/user/change-role")
//    @PreAuthorize("hasRole('ROLE_USER_MANAGE')")
//    public UserViewModel changeUserRole(
//            @ApiParam(
//                    value = "اطلاعات کاربری که نقش های او می بایست به روز رسانی گردد. لیست نقش های جدید کاربر در همین آبجکت قرار میگیرد",
//                    required = true
//            )
//            @RequestBody UserViewModel userViewModel) {
//        return userManagementService.changeUserRole(userViewModel);
//    }
//
//    @ApiOperation(
//            value = "Get all user roles",
//            notes = "دریافت لیست تمامی نقش های یک کاربر"
//    )
//    @GetMapping("get/user-roles/{username}")
//    public List<RoleViewModel> getAllUserRoles(
//            @ApiParam(
//                    value = "نام کاربری شخصی که قصد دریافت لیست نقش های او را دارید",
//                    required = true
//            )
//            @PathVariable(name = "username") String username) {
//        return userManagementService.getAllUserRoles(username);
//    }
//}

package org.msx.software.edu.system.model.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.model.view.util.BaseViewModel;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)

@ApiModel(description = "اطلاعات کاربر سیستم")
public class UserViewModel extends BaseViewModel {

    @ApiModelProperty(notes = "نام کاربری")
    private String username;

    @ApiModelProperty(notes = "نام")
    private String firstName;

    @ApiModelProperty(notes = "نام خانوادگی")
    private String lastName;

    @ApiModelProperty(notes = "آدرس ایمیل")
    private String email;

    @ApiModelProperty(notes = "آدرس تصویر پروفایل کاربر")
    private String profileImageUrl;

    @ApiModelProperty(notes = "لیستی از تمامی کدهای دسترسی کاربر")
    private List<String> roles;
}

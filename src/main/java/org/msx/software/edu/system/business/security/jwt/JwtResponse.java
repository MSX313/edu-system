package org.msx.software.edu.system.business.security.jwt;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@ApiModel(description = "توکن دسترسی شامل اطلاعات کاربر لاگین شده در سیستم")
public class JwtResponse {

    @ApiModelProperty(notes = "توکن دسترسی")
    @NonNull
    private String token;
    @ApiModelProperty(
            notes = "نوع توکن دسترسی")
    @NonNull
    private String type = "Bearer";
    @ApiModelProperty(notes = "نام کاربری")
    @NonNull
    private String username;
    @ApiModelProperty(notes = "نام")
    @NonNull
    private String firstName;
    @ApiModelProperty(notes = "نام خانوادگی")
    @NonNull
    private String lastName;
    @ApiModelProperty(notes = "ایمیل")
    @NonNull
    private String email;
    @ApiModelProperty(notes = "آدرس تصویر پروفایل")
    private String image;
    @ApiModelProperty(notes = "دسترسی های کاربر")
    @NonNull
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(@NonNull String token,
                       @NonNull String username,
                       @NonNull String firstName,
                       @NonNull String lastName,
                       @NonNull String email,
                       String image,
                       @NonNull Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.image = image;
        this.authorities = authorities;
    }
}
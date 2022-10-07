package org.msx.software.edu.system.controller.vm.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)

@ApiModel(description = "فیلدهای اطلاعاتی عمومی مربوط به داده هایی که در دیتابیس ذخیره شده اند")
public class BaseEntityVm extends MasterVm {

    @ApiModelProperty(notes = "شناسه رکورد دیتا")
    private Long id;

    @ApiModelProperty(notes = "شناسه کاربری که دیتا را اضافه کرده")
    private String insertUser;

    @ApiModelProperty(notes = "نام کامل کاربری که دیتا را اضافه کرده")
    private String insertUserFullName;
    @ApiModelProperty(notes = "شناسه کاربری که آخرین ویرایش را بر روی دیتا انجام داده")
    private String updateUser;

    @ApiModelProperty(notes = "نام کامل کاربری که آخرین ویرایش را بر روی دیتا انجام داده")
    private String updateUserFullName;

    @ApiModelProperty(notes = "تاریخ و زمان ایجاد دیتا در دیتابیس")
    private Timestamp insertDateTime;

    @ApiModelProperty(notes = "تاریخ و زمان آخرین ویرایش صورت گرفته بر روی دیتا در دیتابیس")
    private Timestamp updateDateTime;

    @ApiModelProperty(notes = "مشخص کننده اینکه آیا دیتا هنوز فعال و قابل استفاده هست یا خیر")
    @JsonProperty("isActive")
    private Boolean isActive;

    @ApiModelProperty(notes = "نسخه داده ثبت شده در دیتابیس که نمایانگر تعداد دفعات ویرایش رکورد دیتا در دیتابیس می باشد")
    private Integer version;

    public BaseEntityVm() {
        super(BaseEntityVm.class);
    }
}
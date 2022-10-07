package org.msx.software.edu.system.controller.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

@ApiModel(description = "اطلاعات کتگوری ها (ثابت ها) ی موجود در سیستم")
public class CategoryElementVm extends BaseViewModel {

    @ApiModelProperty(notes = "کد کتگوری")
    private String code;

    @ApiModelProperty(notes = "مقدار کتگوری")
    private String value;
}
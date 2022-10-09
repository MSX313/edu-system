package org.msx.software.edu.system.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "اطلاعات در خصوص نرم افزار")
public class ApplicationInfoDto {

    @ApiModelProperty(notes = "نسخه جاری نرم افزار")
    private final String version;
}
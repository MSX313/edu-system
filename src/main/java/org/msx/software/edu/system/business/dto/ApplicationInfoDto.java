package org.msx.software.edu.system.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.business.dto.util.MasterDto;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "اطلاعات در خصوص نرم افزار")
public class ApplicationInfoDto extends MasterDto {

    @ApiModelProperty(notes = "نسخه جاری نرم افزار")
    private final String version;
}
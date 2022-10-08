package org.msx.software.edu.system.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "نمایشگر مقادیر متنی")
@Data
@AllArgsConstructor
public class PlainTextDto {

    @ApiModelProperty(notes = "مقدار متنی")
    String value;
}

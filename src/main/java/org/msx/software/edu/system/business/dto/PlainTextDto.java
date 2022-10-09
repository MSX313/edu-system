package org.msx.software.edu.system.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(description = "??????? ?????? ????")
@Data
@AllArgsConstructor
public class PlainTextDto {

    @ApiModelProperty(notes = "????? ????")
    String value;
}

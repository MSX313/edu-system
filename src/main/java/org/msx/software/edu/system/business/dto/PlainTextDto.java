package org.msx.software.edu.system.business.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.business.dto.util.MasterDto;

@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "??????? ?????? ????")
@Data
@AllArgsConstructor
public class PlainTextDto extends MasterDto {

    @ApiModelProperty(notes = "????? ????")
    String value;
}

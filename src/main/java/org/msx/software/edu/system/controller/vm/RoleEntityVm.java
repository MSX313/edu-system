package org.msx.software.edu.system.controller.vm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.controller.vm.util.BaseEntityVm;

@Data
@EqualsAndHashCode(callSuper = true)

@ApiModel(description = "اطلاعات دسترسی های سیستم")
public class RoleEntityVm extends BaseEntityVm {

    @ApiModelProperty("کد نقش")
    private String roleCode;

    @ApiModelProperty("توضیحات نقش")
    private String roleDescription;
}
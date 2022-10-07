package org.msx.software.edu.system.model.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.model.view.util.BaseViewModel;

@Data
@EqualsAndHashCode(callSuper = true)

@ApiModel(description = "اطلاعات دسترسی های سیستم")
public class RoleViewModel extends BaseViewModel {

    @ApiModelProperty("کد نقش")
    private String roleCode;

    @ApiModelProperty("توضیحات نقش")
    private String roleDescription;
}
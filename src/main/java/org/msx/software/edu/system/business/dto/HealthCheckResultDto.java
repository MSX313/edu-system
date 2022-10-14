package org.msx.software.edu.system.business.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.msx.software.edu.system.business.dto.util.MasterDto;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ApiModel(description = "نتیجه بررسی در دسترس بودن سرویس ها")
public class HealthCheckResultDto extends MasterDto {

    @ApiModelProperty(notes = "این مقدار مشخص میکند که آیا سرویس های هومت در دسترس میباشند یا خیر")
    private boolean serviceOk;

    @ApiModelProperty(notes = "این مقدار مشخص می کند آیا سرور هومت به درستی به دیتابیس دسترسی دارد یا خیر")
    private boolean databaseOk;

    @ApiModelProperty(notes = "در صورتی که مشکلی در ارتباط با دیتابیس وجود داشته باشد جزئیات مشکل را شامل می گردد")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String dbException;
}
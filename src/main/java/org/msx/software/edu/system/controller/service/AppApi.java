package org.msx.software.edu.system.controller.service;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.msx.software.edu.system.business.dto.ApplicationInfoDto;
import org.msx.software.edu.system.business.dto.HealthCheckResultDto;
import org.msx.software.edu.system.business.operation.baseentity.HealthCheckBusiness;
import org.msx.software.edu.system.business.util.IgnoreLogging;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application")
@CrossOrigin
@AllArgsConstructor
public class AppApi {

//    private final BuildProperties buildProperties;
    private final HealthCheckBusiness healthCheckBusiness;

    @ApiOperation(value = "Get application version", notes = "دریافت نسخه جاری. می توان برای بررسی ارتباط با سرور هومت نیز از این سرویس استفاده کرد")
    @GetMapping("/version")
    @IgnoreLogging
    public ApplicationInfoDto getApplicationVersion() {
        // buildProperties.getVersion()
        return new ApplicationInfoDto("");
    }

    @ApiOperation(value = "Check application", notes = "بررسی در دسترس بودن سرویس های هومت")
    @GetMapping("/check")
    @IgnoreLogging
    public HealthCheckResultDto check() {
        return healthCheckBusiness.check();
    }
}
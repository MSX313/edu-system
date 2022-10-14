package org.msx.software.edu.system.controller.service;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.dto.ApplicationInfoDto;
import org.msx.software.edu.system.business.dto.HealthCheckResultDto;
import org.msx.software.edu.system.business.operation.baseentity.HealthCheckBusiness;
import org.msx.software.edu.system.controller.util.IgnoreLogging;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequestMapping("/application")
@CrossOrigin
@EnableWebMvc
@RequiredArgsConstructor
public class AppApi {

    @Value("${app.version}")
    private String appVersion;
    private final HealthCheckBusiness healthCheckBusiness;

    @ApiOperation(value = "Get application version",
            notes = "دریافت نسخه جاری. می توان برای بررسی ارتباط با سرور هومت نیز از این سرویس استفاده کرد")
    @GetMapping("/version")
    @IgnoreLogging
    public ApplicationInfoDto getApplicationVersion() {
        return new ApplicationInfoDto(appVersion);
    }

    @ApiOperation(value = "Check application", notes = "بررسی در دسترس بودن سرویس های هومت")
    @GetMapping("/check")
    @IgnoreLogging
    public HealthCheckResultDto check() {
        return healthCheckBusiness.check();
    }
}
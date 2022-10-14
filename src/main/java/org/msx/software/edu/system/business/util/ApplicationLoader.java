package org.msx.software.edu.system.business.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationLoader implements ApplicationRunner {

    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) {
        String logMsg = String.format(
                "Application is running on %s:%s",
                InetAddress.getLoopbackAddress().getHostAddress(),
                environment.getProperty("local.server.port")
        );
        log.info(logMsg);
    }
}
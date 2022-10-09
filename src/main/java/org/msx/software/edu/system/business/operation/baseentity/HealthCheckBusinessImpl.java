package org.msx.software.edu.system.business.operation.baseentity;

import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.dto.HealthCheckResultDto;
import org.msx.software.edu.system.model.repository.DatabaseHealthCheckRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckBusinessImpl implements HealthCheckBusiness {

    private final DatabaseHealthCheckRepository healthCheckRepository;

    @Override
    public HealthCheckResultDto check() {
        boolean appOk = true;
        boolean dbOk = false;
        String dbException = null;
        try {
            Long result = healthCheckRepository.checkDatabase();
            dbOk = result == 1;
        } catch (Exception e) {
            dbException = e.getLocalizedMessage();
        }
        return new HealthCheckResultDto(appOk, dbOk, dbException);
    }
}
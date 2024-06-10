package com.leadsgen.project.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class  HealthCheckIndicator implements HealthIndicator {

    @Override
    public Health health() {
 
        boolean serviceUp = checkHealth();
        long freeMemory= Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        if (serviceUp) {
            
            return Health.up()
            .withDetail("freeMemory",freeMemory)
            .withDetail("totalMemory", totalMemory)
            .build();
        } else {
            return Health.down()
            .withDetail("Downstream Service", "Unavailable")
            .build();
        }


    }
    private boolean checkHealth() {
        return true;
    }
}

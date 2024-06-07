package com.leadsgen.project.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class DownstreamServiceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
 
        boolean serviceUp = checkDownstreamServiceHealth();

        if (serviceUp) {
            return Health.up().withDetail("Downstream Service", "Available").build();
        } else {
            return Health.down().withDetail("Downstream Service", "Unavailable").build();
        }
    }
    private boolean checkDownstreamServiceHealth() {
        return true;
    }
}

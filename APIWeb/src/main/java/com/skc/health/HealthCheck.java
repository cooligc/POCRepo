package com.skc.health;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

@Component
public class HealthCheck implements HealthIndicator {
	
	@Autowired
	CounterService counterService;

	@Override
	public Health health() {
		if(check()==1){
			return Health.down().build();
		}else if(check()==2){
			return Health.outOfService().build();
		}else{
			return Health.up().build();
		}
	}

	private int check() {
		counterService.increment("health.counter.status");
		return new Random().nextInt() % 3;
	}
}

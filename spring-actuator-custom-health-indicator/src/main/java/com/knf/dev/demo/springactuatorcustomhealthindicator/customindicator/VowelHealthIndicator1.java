package com.knf.dev.demo.springactuatorcustomhealthindicator.customindicator;

import java.util.Random;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class VowelHealthIndicator1 implements HealthIndicator {

	@Override
	public Health health() {

		char character = randomGenerator();
		switch (character) {
		case 'a':
			return Health.up().withDetail("status", character + " is vowel").build();
		case 'e':
			return Health.up().withDetail("status", character + " is vowel").build();
		case 'i':
			return Health.up().withDetail("status", character + " is vowel").build();
		case 'o':
			return Health.up().withDetail("status", character + " is vowel").build();
		case 'u':
			return Health.up().withDetail("status", character + " is vowel").build();
		default:
			return Health.down().withDetail("error", character + " is consonant").build();

		}

	}

	private static char randomGenerator() {

		Random r = new Random();
		String alphabet = "abcdefgiopuxlm";
		return alphabet.charAt(r.nextInt(alphabet.length()));
	}
}

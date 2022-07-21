package com.knf.dev.demo.springactuatorcustomhealthindicator.customindicator;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class VowelHealthIndicator2 extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Health.Builder builder) {

		char character = randomGenerator();
		switch (character) {
		case 'a':
			builder.up().withDetail("status", character + " is vowel").build();
		case 'e':
			builder.up().withDetail("status", character + " is vowel").build();
		case 'i':
			builder.up().withDetail("status", character + " is vowel").build();
		case 'o':
			builder.up().withDetail("status", character + " is vowel").build();
		case 'u':
			builder.up().withDetail("status", character + " is vowel").build();
			break;
		default:
			builder.down().withDetail("error", character + " is consonant").build();

		}

	}

	private static char randomGenerator() {

		Random r = new Random();
		String alphabet = "abcdefgiopuxlm";
		return alphabet.charAt(r.nextInt(alphabet.length()));
	}
}

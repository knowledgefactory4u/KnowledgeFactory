package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {

	private static final Logger LOG = LoggerFactory.getLogger(TestService.class);

	public void processData() {
		LOG.info("Inside Test Service");
	}
}

package com.knf.sibin.dev.emaildemo;

import java.io.IOException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.knf.sibin.dev.emaildemo.util.EmailUtil;

@SpringBootApplication
public class EmailDemoApplication implements CommandLineRunner {
	@Autowired
	private EmailUtil emailUtil;

	public static void main(String[] args) {
		SpringApplication.run(EmailDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			emailUtil.sendEmail();
		} catch (MessagingException | IOException e) {

			e.printStackTrace();
		}

	}
}

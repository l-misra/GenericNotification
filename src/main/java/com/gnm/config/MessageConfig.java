package com.gnm.config;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.gnm.constant.MessageConstant;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.msg.processor.impl.EmailProcessor;
import com.gnm.msg.processor.impl.SMSProcessor;
import com.gnm.msg.processor.impl.SlackProcessor;

@Configuration
public class MessageConfig {

	@PostConstruct
	public void startListener() {
		System.out.println("Listening to queue");
	}

	/*
	 * @Bean public TaskExecutor threadPoolTaskExecutor() { ThreadPoolTaskExecutor
	 * executor = new ThreadPoolTaskExecutor(); executor.setCorePoolSize(4);
	 * executor.setMaxPoolSize(4);
	 * executor.setThreadNamePrefix("default_task_executor_thread");
	 * executor.initialize(); return executor; }
	 */

	@Bean(name = "applicationEventMulticaster")
	public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
		SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();

		eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
		return eventMulticaster;
	}

	@Bean(name = MessageConstant.MSG_TYPE_EMAIL)
	MessageProcessor getEmail() {
		return new EmailProcessor();
	}

	@Bean(name = MessageConstant.MSG_TYPE_SLACK)
	MessageProcessor getSlackProcessor() {
		return new SlackProcessor();
	}

	@Bean(name = MessageConstant.MSG_TYPE_SMS)
	MessageProcessor getSMSProcessor() {
		return new SMSProcessor();
	}

	
	// TO-DO : ADD BELOW PROPERITES TO A PROPERTIES FILE
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("mail2arunmisra@gmail.com");
		mailSender.setPassword("");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}

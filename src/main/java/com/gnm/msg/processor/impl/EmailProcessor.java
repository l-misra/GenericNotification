package com.gnm.msg.processor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.gnm.entity.MessageTemplate;
import com.gnm.error.ErrorDetails;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.response.MessageResponse;

public class EmailProcessor implements MessageProcessor {

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public MessageResponse processMessage(MessageTemplate template) {

		System.out.println("Processing email message:[ " + template + " ]");

		MessageResponse response = new MessageResponse();
		try {
			sendSimpleMessage(template.getMsgTo(), template.getSubject(), "");
			response.setSuccess(true);
		} catch (Exception e) {
			response.setErrorCode(ErrorDetails.UNABLE_TO_SEND_EMAIL);
			
		}

		return response;

	}

}

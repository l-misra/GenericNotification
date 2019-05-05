package com.gnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gnm.entity.MessageTemplate;
import com.gnm.response.MessageResponse;
import com.gnm.service.MessageTemplateService;

@RestController
public class MessageController {

	@Autowired
	private MessageTemplateService service;

	@PostMapping(value = "/processMessage", consumes = "application/json")
	public ResponseEntity processMessage(@RequestBody MessageTemplate template) {

		MessageResponse messageResponse = service.processMessage(template);

		if (messageResponse.getSuccess()) {
			return ResponseEntity.ok(messageResponse);
		} else {
			return ResponseEntity.badRequest().body(messageResponse);
		}

	}

}

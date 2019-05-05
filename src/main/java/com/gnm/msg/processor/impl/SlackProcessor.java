package com.gnm.msg.processor.impl;

import com.gnm.entity.MessageTemplate;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.response.MessageResponse;

public class SlackProcessor implements MessageProcessor {

	// TO-DO : Implements this method properlly
	@Override
	public MessageResponse processMessage(MessageTemplate template) {

		MessageResponse response = new MessageResponse();
		System.out.println("Processing slack message!!!");

		return response;
	}

}

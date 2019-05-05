package com.gnm.msg.processor.impl;

import com.gnm.entity.MessageTemplate;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.response.MessageResponse;

public class SMSProcessor implements MessageProcessor {

	// TO-DO : FULLY CONCRETE IMPLEMENTATION OF THIS METHOD IS LEFT.
	@Override
	public MessageResponse processMessage(MessageTemplate template) {
		MessageResponse response = new MessageResponse();
		System.out.println("Processing SMS message!!!");
		return response;
	}

}

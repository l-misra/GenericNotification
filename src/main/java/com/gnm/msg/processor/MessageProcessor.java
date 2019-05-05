package com.gnm.msg.processor;

import com.gnm.entity.MessageTemplate;
import com.gnm.response.MessageResponse;

public interface MessageProcessor {
	
	MessageResponse processMessage( MessageTemplate template);
}



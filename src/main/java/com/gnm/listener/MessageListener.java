package com.gnm.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gnm.entity.MessageTemplate;
import com.gnm.msg.broker.MessageBroker;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.response.MessageResponse;

@Component
public class MessageListener implements ApplicationListener<MessageBroker> {

	@Autowired
	ApplicationContext ctx;

	@Override
	public void onApplicationEvent(MessageBroker event) {
		System.out.println("Received spring custom event - " + event.getReceivedMessage());

		if (null != event) {
			MessageTemplate template = event.getReceivedMessage();
			String msgType = template.getMsgType().toUpperCase().trim();

			MessageProcessor messageProcessor = (MessageProcessor) ctx.getBean(msgType);
			MessageResponse processMessage = messageProcessor.processMessage(template);

			if (processMessage.getSuccess()) {
				System.out.println("successfully processed message:");
			} else {
				// TO-DO : ADD TO ERROR QUEUE FOR FURHTER REFERENCE.
			}

		} else {
			// TO-DO : ADD TO ERROR QUEUE FOR FURHTER REFERENCE.
			System.err.println("Empty event found!!!");
		}

	}
}

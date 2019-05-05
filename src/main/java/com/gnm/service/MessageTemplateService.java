package com.gnm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.gnm.constant.MessageConstant;
import com.gnm.entity.MessageTemplate;
import com.gnm.error.ErrorDetails;
import com.gnm.msg.broker.MessageBroker;
import com.gnm.msg.processor.MessageProcessor;
import com.gnm.response.MessageResponse;

/**
 * Service class to process message.
 * 
 * @author lingaraj
 *
 */
@Service
public class MessageTemplateService {

	// TO-DO : Instead of this message broker we can use apache active mq.
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	MessageBroker msgBroker = new MessageBroker(this, 50);

	public MessageResponse processMessage(MessageTemplate template) {

		MessageResponse response = new MessageResponse(false);

		if (null != template) {

			// validation for msgtype;
			String msgType = template.getMsgType();

			if (null != msgType && (msgType = msgType.trim().toUpperCase()).length() != 0 && MessageConstant.SUPPORTED_MSG_TYPES.contains(msgType)) {

				try {
					msgBroker.enqueue(template);
					System.out.println(msgBroker.getReceivedMessage());
					response.setSuccess(true);
					System.out.println("PUSHED TO QUEUE , MSG : [ " + template + " ]");
					
					applicationEventPublisher.publishEvent(msgBroker);

				} catch (InterruptedException e) {
					System.err.println("ERROR DURING PUSING TO QUEUE : [ " + template + " ]");
					response.setErrorCode(ErrorDetails.UNABLE_TO_PUSH_TO_QUEUE);
					response.setErrorMessage("Error occurred while pushing msg to queue!!");
				}

				return response;

			} else {
				response.setErrorCode(ErrorDetails.NULL_EMPTY_FOUND);
				response.setErrorMessage(
						"No msg Type found, supported msg types are : [ " + MessageConstant.SUPPORTED_MSG_TYPES + " ]");
			}

		} else {
			response.setErrorCode(ErrorDetails.NULL_EMPTY_FOUND);
			response.setErrorMessage("No message found, please provide a valid input");
		}

		// Remove below lines

		return response;

	}

}

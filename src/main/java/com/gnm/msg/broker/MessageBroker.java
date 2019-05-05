package com.gnm.msg.broker;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.ApplicationEvent;

import com.gnm.entity.MessageTemplate;

public class MessageBroker extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Note : If needed we can go for active mq and multi threading.
	private List<MessageTemplate> queue = new LinkedList<MessageTemplate>();

	private int limit = 10;

	public MessageBroker(Object source, int limit) {
		super(source);
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add((MessageTemplate) item);
	}

	public synchronized Object dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}

	public MessageTemplate getReceivedMessage() {
		if (!queue.isEmpty()) {
			return queue.get(queue.size() - 1);
		} else {
			System.out.println("Queue is empty!!!");
			return null;
		}

	}

}

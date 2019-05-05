package com.gnm.entity;

/**
 * This class is used as message template to hold message details.
 * 
 * @author lingaraj
 *
 */
public class MessageTemplate {

	private String msgTo;

	private String msgFrom;

	private String subject;

	private String msgType;

	public MessageTemplate() {
	}

	/**
	 * @param msgTo
	 * @param msgFrom
	 * @param subject
	 * @param msgType
	 */
	public MessageTemplate(String msgTo, String msgFrom, String subject, String msgType) {
		super();
		this.msgTo = msgTo;
		this.msgFrom = msgFrom;
		this.subject = subject;
		this.msgType = msgType;
	}

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgTo() {
		return msgTo;
	}

	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	public String getMsgFrom() {
		return msgFrom;
	}

	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MessageTemplate [msgTo=" + msgTo + ", msgFrom=" + msgFrom + ", subject=" + subject + ", msgType="
				+ msgType + "]";
	}

}

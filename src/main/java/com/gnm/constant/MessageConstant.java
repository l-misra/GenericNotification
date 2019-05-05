package com.gnm.constant;

import java.util.Arrays;
import java.util.List;

public interface MessageConstant {

	String MSG_TYPE_EMAIL = "EMAIL";
	String MSG_TYPE_SLACK = "SLACK MESSAGE";
	String MSG_TYPE_SMS = "SMS";

	List<String> SUPPORTED_MSG_TYPES = Arrays.asList(new String[] { MSG_TYPE_EMAIL, MSG_TYPE_SLACK, MSG_TYPE_SMS });

}

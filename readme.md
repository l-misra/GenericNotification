# Getting Started

Application : Is a sample application for notification system.

Currently it support for Email Notification.
And a dummy version of SMS and Slack notification is implemented.

# How to test this application.
----------------------------------
Right click and execute GenericNotificationApplication.java.

open postman
and use below url to send message , see sample screen shot /GenericNotification/Sample.PNG  
http://localhost:2020/processMessage

In console log you can see email related messages.

Similarly you can do a dummy test for SMS using below post body

	{
        "msgTo": "9748210278",
        "msgFrom": "9748210278",
        "subject": "subject",
        "msgType" : "sms"
        
    }
    
# Pending :
1. - ve test cases needs to be verified and corrected.
2. Validation of correct email and number are left.

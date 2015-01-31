package org.jacademie.firstejb.service;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: TicketListener
 *
 */
@MessageDriven(
		mappedName = "jms/Queue",
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue"
		) })
public class TicketListener implements MessageListener {
	
    /**
     * Default constructor. 
     */
    public TicketListener() {
    }
	
	/**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {    	
    	try {
    		TextMessage msg = (TextMessage)message;
    		
    		System.out.println("Processing : " + msg.getText());
    	} 
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    }

}

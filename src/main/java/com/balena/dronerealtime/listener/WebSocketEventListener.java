package com.balena.dronerealtime.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @Component tells the Spring container that this is a regular injectable class so this class can be injected
 * at other places where it is a dependency.
 * Spring would not be able to inject the class as a dependency if it is not annotated as such or one of the
 * other stereotypes.
 * <p>
 * This class allows listen for connect and disconnect events to log or even broadcast them.
 * <p>
 * This class is not necessary.
 */
@Component
public class WebSocketEventListener {

    /**
     * We inject an instance of SimpMessageSendingOperations which allows us broadcast events to users subscribed
     * to a particular topic.
     */
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);


    /**
     * This method listens for Socket connections as indicated by the parameter type (SessionConnectedEvent)
     *
     * @param event
     * @throws Exception
     */

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {

        logger.info("Received a new web socket connection");
    }

    /**
     * This method listens for Socket disconnections as indicated by the parameter type (SessionDisconnectEvent)
     *
     * @param event
     */
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {

        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String clientId = headerAccessor.getSessionAttributes().get("clientId").toString();

        if (clientId != null) {
            logger.info("User Disconnected : $clientId");
        }

    }
}

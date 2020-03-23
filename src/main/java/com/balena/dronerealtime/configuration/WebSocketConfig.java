package com.balena.dronerealtime.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * This is also a configuration class.
 *
 * @EnableWebSocketMessageBroker is used to enable our WebSocket Server.
 * <p>
 * We implement WebSocketMessageBrokerConfigurer so we can provide implementation for some
 * of its methods to configure the websocket connection.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * Here, we register a websocket endpoint that the clients will use to connect to our websocket server.
     * SockJs is used to enable fallback options for browsers that don't support websocket.
     * The Stomp part of the method name stands for Simple Text Oriented Messaging Protocol.
     * <p>
     * It is a messaging protocol that defines the format and rules for data exchange like how to send
     * a message to only subscribers who are subscribed to a particular topic.
     *
     * @param registry
     */

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/drt").withSockJS();
    }


    /**
     * Here we are configuring a message broker that will be used to route messages from one client to another.
     * <p>
     * The first line defines that the messages whose destinations start with "app" should be routed to message-handling
     * methods (methods annotated with @MessageMapping).
     * <p>
     * The second line defines that the messages whose destination starts with "/topic" should be routed to the
     * message-broker. Message broker broadcasts messages to all the connected clients who are subscribed to a particular
     * topic.
     * <p>
     * In this application, we are using a simple in-memory message broker. In production scenarios, we could have a full
     * blown RabbitMQ or ActiveMQ broker.
     *
     * @param registry
     */

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }

}

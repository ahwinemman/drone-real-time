package com.balena.dronerealtime.controller;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
public class MqttController {

    @Autowired
    private IMqttClient mqttClient;

    public void publish(String topic, String payload, int qos, boolean retained) throws MqttException {

        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(payload.getBytes());
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);

        //        mqttClient.publish(topic, mqttMessage);

        mqttClient.publish(topic, payload.getBytes(), qos, retained);

    }


    public void subscribe(String topic) throws MqttException {

        System.out.println("Messages received:");

//        mqttClient.subscribeWithResponse(topic, (s, mqttMessage) -> {
//            System.out.println("Received messages");
//        });
    }
}



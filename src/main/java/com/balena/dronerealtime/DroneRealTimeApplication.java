package com.balena.dronerealtime;

import com.balena.dronerealtime.controller.MqttController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DroneRealTimeApplication implements CommandLineRunner {

    @Autowired
    MqttController messagingService;

    @Value("${mqtt.realtime.topic}")
    String TOPIC;

	public static void main(String[] args) {
		SpringApplication.run(DroneRealTimeApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//
//	    messagingService.subscribe(TOPIC);
//
//        while (true) {
//            Thread.sleep(3000); // simulated delay
//            messagingService.publish(TOPIC, "{ \"uniqueId\": "  +  1111 + ", \"prevLocation\": " + "\"23.4, 43.5\"" + ", \"currLocation\": " +"\"3.4, 53.5\"" + "}", 0, true);
//
//        }


//        for (int i = 0; i < 1000; i++) {
//            String publisherId = UUID.randomUUID().toString();
//            IMqttClient publisher = new MqttClient("", publisherId);
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setAutomaticReconnect(true);
//            options.setCleanSession(true);
//            options.setConnectionTimeout(10);
//            publisher.connect(options);
//        }

    }
}

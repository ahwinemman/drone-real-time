package com.balena.dronerealtime.configuration;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MQTT CONFIGURATION CLASS
 * <p>
 * The class contains proposed configuration the client/publisher would require to connect to the server.
 * <p>
 * The class is here for testing purposes.
 *
 * @COnfiguration is how we tell the Spring container that this class will expose configuraiton beans
 * that could then be @Autowired / injected at other parts of the application.
 */
@Configuration
public class MqttClientConfig {

    /**
     * The @Value annotation instructs the container to look into the external "application.properties"
     * for the values in the brackets.
     * <p>
     * "application.properties" is in the resources folder of the "main directory"
     */
    @Value("${mqtt.automaticReconnect}")
    private boolean automaticReconnect;

    @Value("${mqtt.cleanSession}")
    private boolean cleanSession;

    @Value("${mqtt.connectionTimeout}")
    private int connectionTimeout;


    /**
     * @param clientId clientId is picked from the external configuration file
     * @param hostname a public broker hostname that can be used for testing purposes
     * @param port     broker port which is typically 1883
     * @return
     * @throws MqttException
     */
    @Bean
    public IMqttClient mqttClient(@Value("${mqtt.clientId}") String clientId,
                                  @Value("${mqtt.hostname}") String hostname, @Value("${mqtt.port}") int port) throws MqttException {

        MqttClient mqttClient = new MqttClient("tcp://" + hostname + ":" + port, clientId);

        mqttClient.connect(mqttConnectOptions());

        return mqttClient;
    }

    @Bean
    @ConfigurationProperties(prefix = "mqtt")
    public MqttConnectOptions mqttConnectOptions() {

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);

        return options;

    }
}

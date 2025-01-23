package com.oussama.rabbitmicro;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {


    @Value("$spring.application.name")
    private String nameApp;

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void listener(CustomMessage message) {
        System.out.println("Received message: " + message + " <------- :" + nameApp);
    }

}

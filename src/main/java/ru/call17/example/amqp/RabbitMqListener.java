package ru.call17.example.amqp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit //нужно для активации обработки аннотаций @RabbitListener
@Component
public class RabbitMqListener {
    Logger logger = LogManager.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "spring-boot")
    public void processQueue1(String message) {
        logger.info("Received from spring-boot: " + message);
    }

    @RabbitListener(queues = "with-response")
    public String processQueue1WithReponse(String message) {
        logger.info("Received from with-response: " + message);

        return "response from rabbit";
    }
}
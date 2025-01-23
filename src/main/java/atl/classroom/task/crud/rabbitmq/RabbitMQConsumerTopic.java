package atl.classroom.task.crud.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static atl.classroom.task.crud.rabbitmq.RabbitMQConfigTopic.QUEUE_NAME_CUSTOMER;
import static atl.classroom.task.crud.rabbitmq.RabbitMQConfigTopic.ROUTING_KEY_PERSONNEL;

@Component
public class RabbitMQConsumerTopic {

//    @RabbitListener(queues = QUEUE_NAME_CUSTOMER)
//    public void listen2(String message) {
//        System.out.println("QUEUE_NAME_CUSTOMER: " + message);
//    }
//
//    @RabbitListener(queues = ROUTING_KEY_PERSONNEL)
//    public void listen3(String message) {
//        System.out.println("ROUTING_KEY_PERSONNEL: " + message);
//    }
}

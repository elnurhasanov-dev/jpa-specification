package atl.classroom.task.crud.rabbitmq.Topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfigTopic {

    public static final String QUEUE_NAME_CUSTOMER = "myTopicCustomersQueue";
    public static final String QUEUE_NAME_PERSONNEL = "myTopicPersonnelicsQueue";
    public static final String QUEUE_NAME_INTERNATIONAL = "myTopicInternationalQueue";

    public static final String EXCHANGE_NAME_TOPIC = "myTopicExchange";

    public static final String ROUTING_KEY_CUSTOMER = "order.logs.personnel.*";
    public static final String ROUTING_KEY_PERSONNEL = "order.logs.personnel.electronics";
    public static final String ROUTING_KEY_INTERNATIONAL = "order.logs.international.electronics";

    @Bean
    public Queue customerQueue() {
        return new Queue(QUEUE_NAME_CUSTOMER, true); // durable queue
    }

    @Bean
    public Queue personnelQueue() {
        return new Queue(QUEUE_NAME_PERSONNEL, true); // durable queue
    }

    @Bean
    public Queue internationalQueue() {
        return new Queue(QUEUE_NAME_INTERNATIONAL, true); // durable queue
    }

    @Bean
    public TopicExchange exchangeTopic() {
        return new TopicExchange(EXCHANGE_NAME_TOPIC);
    }

    @Bean
    public Binding customerBinding(@Qualifier("customerQueue") Queue customerQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(customerQueue).to(topicExchange).with(ROUTING_KEY_CUSTOMER);
    }

    @Bean
    public Binding personnelBinding(@Qualifier("personnelQueue") Queue personnelQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(personnelQueue).to(topicExchange).with(ROUTING_KEY_PERSONNEL);
    }

    @Bean
    public Binding internationalBinding(@Qualifier("internationalQueue") Queue internationalQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(internationalQueue).to(topicExchange).with(ROUTING_KEY_INTERNATIONAL);
    }

}
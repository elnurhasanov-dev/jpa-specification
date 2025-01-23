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
    // Exchange
    public static final String X_PICTURE = "x.picture";

    // Queues
    public static final String QUEUE_PICTURE_FILTER = "q.picture.filter";
    public static final String QUEUE_PICTURE_IMAGE = "q.picture.image";
    public static final String QUEUE_PICTURE_LOG = "q.picture.log";
    public static final String QUEUE_PICTURE_VECTOR = "q.picture.vector";

    // Routing Keys
    public static final String ROUTING_KEY_PNG = "*.*.png";
    public static final String ROUTING_KEY_JPG = "#.jpg";
    public static final String ROUTING_KEY_SVG = "*.*.svg";
    public static final String ROUTING_KEY_MOBILE = "mobile.#";
    public static final String ROUTING_KEY_LARGE_SVG = "*.large.svg";

    @Bean
    public TopicExchange exchangeTopic() {
        return new TopicExchange(X_PICTURE);
    }

    @Bean
    public Queue filterQueue() {
        return new Queue(QUEUE_PICTURE_FILTER, true); // durable queue
    }

    @Bean
    public Queue imageQueue() {
        return new Queue(QUEUE_PICTURE_IMAGE, true); // durable queue
    }

    @Bean
    public Queue logQueue() {
        return new Queue(QUEUE_PICTURE_LOG, true); // durable queue
    }

    @Bean
    public Queue vectorQueue() {
        return new Queue(QUEUE_PICTURE_VECTOR, true);
    }

    @Bean
    public Binding filterBinding(@Qualifier("filterQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_MOBILE);
    }

    @Bean
    public Binding imageBindingJpg(@Qualifier("imageQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_JPG);
    }

    @Bean
    public Binding imageBindingPng(@Qualifier("imageQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_PNG);
    }

    @Bean
    public Binding logBinding(@Qualifier("logQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_LARGE_SVG);
    }

    @Bean
    public Binding vectorBinding(@Qualifier("logQueue") Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY_SVG);
    }

}
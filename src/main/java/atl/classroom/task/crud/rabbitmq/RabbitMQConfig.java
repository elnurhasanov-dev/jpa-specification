package atl.classroom.task.crud.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final String personQ;

    private final String personDLQ;

    private final String personQExchange;

    private final String personDLQExchange;

    private final String personQKey;

    private final String personDLQKey;

    public RabbitMQConfig(@Value("${rabbitmq.queue.person}") String personQ,
                          @Value("${rabbitmq.queue.person-dlq}") String personDlq) {
        this.personQ = personQ;
        this.personDLQ = personDlq;
        this.personQExchange = personQ + "_Exchange";
        this.personDLQExchange = personDlq + "_Exchange";
        this.personQKey = personQ + "_Key";
        this.personDLQKey = personDlq + "_Key";
    }

    @Bean
    DirectExchange personDLQExchange() {
        return new DirectExchange(personDLQExchange);
    }

    @Bean
    DirectExchange personQExchange() {
        return new DirectExchange(personQExchange);
    }

    @Bean
    Queue personDLQ() {
        return QueueBuilder.durable(personDLQ).build();
    }

    @Bean
    Queue personQ() {
        return QueueBuilder.durable(personQ)
                .withArgument("x-dead-letter-exchange", personDLQExchange)
                .withArgument("x-dead-letter-routing-key", personDLQKey)
                .build();
    }

    @Bean
    Binding personDLQBinding() {
        return BindingBuilder.bind(personDLQ())
                .to(personDLQExchange())
                .with(personDLQKey);
    }

    @Bean
    Binding personQBinding() {
        return BindingBuilder.bind(personQ())
                .to(personDLQExchange())
                .with(personDLQKey);
    }
}

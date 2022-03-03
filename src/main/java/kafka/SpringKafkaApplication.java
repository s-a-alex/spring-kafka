package kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import util.KafkaProducerMessage;

@SpringBootApplication(scanBasePackages= {"config"})
@Slf4j
public class SpringKafkaApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringKafkaApplication.class, args);
        KafkaProducerMessage kafkaProducerMessage = ctx.getBean(KafkaProducerMessage.class);
        for (int i = 0; i < 10; ++i) kafkaProducerMessage.sendMessage("Message: " + i);

        System.in.read();
        ctx.close();
    }

}

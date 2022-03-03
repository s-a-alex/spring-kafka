package kafka;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import util.KafkaConsumingMessages;
import util.KafkaProducerMessage;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class SpringKafkaApplicationTests {

    @Autowired
    private KafkaProducerMessage kafkaProducerMessage;
    @Autowired
    private KafkaConsumingMessages kafkaConsumingMessages;

    @Test
    void testRun() throws InterruptedException {
        for(int i=0;i<10;i++) kafkaProducerMessage.sendMessage("Message: " + i);
        assert(kafkaConsumingMessages.getCountDownLatch().await(10000, TimeUnit.MILLISECONDS));
    }

}

package util;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
public class KafkaConsumingMessages {

    @Setter
    @Getter
    private CountDownLatch countDownLatch=new CountDownLatch(10);

    @KafkaListener(topics = "topic1", groupId = "kafkaTest")
    public void listenGroup(String message) {
        log.info("Received Message in group kafkaTest: " + message);
        getCountDownLatch().countDown();
    }

//    @KafkaListener(topics = "topic1", groupId = "kafkaTest")
//    public void listenWithHeaders(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        log.info("Received Message: " + message + " from partition: " + partition);
//        getCountDownLatch().countDown();
//    }
}

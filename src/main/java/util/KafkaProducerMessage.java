package util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
@Slf4j
public class KafkaProducerMessage {

    @Autowired
    private KafkaTemplate<String, ValueClass> kafkaTemplate;

    public void sendMessage(String message) {

        ListenableFuture<SendResult<String, ValueClass>> future = kafkaTemplate.send("topic1", new ValueClass("value", message));

        future.addCallback(new ListenableFutureCallback<SendResult<String, ValueClass>>() {

            @Override
            public void onSuccess(SendResult<String, ValueClass> result) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }}

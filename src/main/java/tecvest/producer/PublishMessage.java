package tecvest.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import tecvest.payment.Payment;

@Service
public class PublishMessage {
    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public void sendMessage(String topicName, Payment message) {
        ListenableFuture<SendResult<String, Payment>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Payment>>() {

            @Override
            public void onSuccess(SendResult<String, Payment> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });
    }
}

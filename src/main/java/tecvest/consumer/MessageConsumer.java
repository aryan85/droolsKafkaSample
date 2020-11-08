package tecvest.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tecvest.payment.Payment;

@Service
public class MessageConsumer {
/*    @KafkaListener(
            topics = "quickstart-events",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void listenGroupFoo(Payment payment) {
        System.out.println(payment.toString());
    }*/
}

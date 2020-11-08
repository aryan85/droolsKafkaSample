package tecvest.payment;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tecvest.producer.PublishMessage;

@Service
public class PaymentComponent {

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private PublishMessage publishMessage;

    @KafkaListener(
            topics = "quickstart-events",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void doPayment(Payment payment){
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(payment);
        kieSession.fireAllRules();
        kieSession.dispose();
        publishMessage.sendMessage("payment-result",payment);
    }
}

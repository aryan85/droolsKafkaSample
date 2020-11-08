package tecvest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tecvest.payment.Payment;
import tecvest.producer.PublishMessage;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Controller
public class ProducerController {

    @Autowired
    private PublishMessage publishMessage;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    @ResponseBody
    public void sendMessage(@RequestParam @NotBlank String cardNo, @RequestParam @NotNull BigDecimal amount, @RequestParam @NotNull BigDecimal monthlyAmount) {
        publishMessage.sendMessage("quickstart-events", new Payment(cardNo,amount,monthlyAmount));
    }


}

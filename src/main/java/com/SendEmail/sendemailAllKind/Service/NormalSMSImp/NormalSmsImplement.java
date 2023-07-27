package com.SendEmail.sendemailAllKind.Service.NormalSMSImp;

import com.SendEmail.sendemailAllKind.Service.SendNormalMessageService;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static com.SendEmail.sendemailAllKind.Utils.NormalSmsUtils.NormalSmsMessage;

@Service
public class NormalSmsImplement implements SendNormalMessageService {
    @Value("${TWILIO_ACCOUNT_SID}")
    String ACCOUNT_SID;
    @Value("${TWILIO_AUTH_TOKEN}")
    String AUTH_TOKEN;

    @Value("${TWILIO_OUTGOING_SMS_NUMBER}")
    String OUTGOING_SMS_NUMBER;

     @PostConstruct
     private void setup(){
        Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
    }
    @Override
    public String sendMessageToProjectOwner(String toPhoneNumber, String ownerName,String projectTitle) {
        Message message = Message.creator(
                  new PhoneNumber(toPhoneNumber),
                new PhoneNumber(OUTGOING_SMS_NUMBER),
                NormalSmsMessage(ownerName, projectTitle)
        ).create();
        return message.getStatus().toString();
    }
}

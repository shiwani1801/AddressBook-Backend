package com.example.addressbooks.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {
    @Autowired
    JavaMailSender sender;

    public void sendMail(String toEmail ,String subject,String body){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("shiwanipaunikar1@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        sender.send(simpleMailMessage);
        System.out.println("Mail has send to the user......");

    }
}

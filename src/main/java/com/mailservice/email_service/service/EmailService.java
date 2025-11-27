package com.mailservice.email_service.service;

import com.mailservice.email_service.dto.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactRequest request) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(System.getenv("SPRING_MAIL_USERNAME"));
            message.setTo("khushiparikh2603@gmail.com"); // your receiving email
            message.setSubject("New Contact Form Submission from " + request.getName());
            message.setText(
                    "Name: " + request.getName() + "\n" +
                            "Email: " + request.getEmail() + "\n" +
                            "Message: \n" + request.getMessage()
            );

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
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
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("khushiparikh2603@gmail.com"); // your receiving email
        message.setSubject("New Contact Form Submission from " + request.getName());
        message.setText(
                "Name: " + request.getName() + "\n" +
                        "Email: " + request.getEmail() + "\n" +
                        "Message: \n" + request.getMessage()
        );

        mailSender.send(message);
    }
}

package com.hotel.backend.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author HP
 */

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    public void sendSimpleMessage(String to, String subject, String body) {
        //MimeMessage is used to send email
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("aptechdhtv292001@gmail.com");
            helper.setTo(to);
            helper.setSubject(subject);
            message.setContent(body, "text/html");
            mailSender.send(message);
            System.out.println("Sending email...");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

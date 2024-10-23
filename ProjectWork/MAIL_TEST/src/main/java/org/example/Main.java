package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // Email configuration properties
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        prop.put("mail.smtp.port", "2525");  // Using Mailtrap's standard port for STARTTLS
        prop.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");

        // Session creation with authentication
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("5304d5d1d22b53", "8629be62714100");
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("habittracker123@wp.pl"));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse("habittracker123@wp.pl"));
            message.setSubject("Mail Subject");

            // Email body content
            String msg = "This is my first email using JavaMailer";

            // Create MimeBodyPart
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

            // Create Multipart and add MimeBodyPart to it
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            // Set the content of the message
            message.setContent(multipart);

            // Send the email
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();  // This provides a more detailed error message
        }
    }
}

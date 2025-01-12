package com.i2i.datadito;

import com.i2i.datadito.kafka.KafkaTopicConstants;
import com.i2i.datadito.kafka.MessageConsumer;
import com.i2i.datadito.kafka.message.NotificationMessage;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class NotificationService {

    private final MessageConsumer<NotificationMessage> consumer;

    // Constructor ile Kafka Consumer başlatılır
    public NotificationService() {
        consumer = new MessageConsumer<>();
        consumer.createNotificationMessageConsumer(); // Kafka Consumer hazır
    }

    // E-posta gönderim metodu
    private void sendEmail(String recipient, String subject, String body) {
        final String senderEmail = "i2iemailsender@gmail.com"; // E-posta adresinizi girin
        final String senderPassword = "iikn hcld bsjq nexz"; // E-posta şifrenizi girin

        Properties emailProps = new Properties();
        emailProps.put("mail.smtp.host", "smtp.gmail.com");
        emailProps.put("mail.smtp.port", "587");
        emailProps.put("mail.smtp.auth", "true");
        emailProps.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(emailProps, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully to: " + recipient);
        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }

    // Kafka'dan gelen mesajları işleyen metot
    public void pollAndProcessMessages() {
        try {
            while (true) {
                var records = consumer.poll(); // Kafka'dan mesajları al
                if (records != null) {
                    records.forEach(record -> processNotificationMessage(record.value()));
                }
            }
        } catch (Exception e) {
            System.err.println("Error while polling Kafka messages: " + e.getMessage());
        }
    }

    // NotificationMessage'i işler ve uygun e-postayı gönderir
    private void processNotificationMessage(NotificationMessage message) {
        String email = message.getEmail();
        String name = message.getName();
        String type = message.getType().name(); // SMS, DATA, VOICE
        String threshold = message.getThreshold(); // 80, 100

        if ("80".equals(threshold)) {
            sendEmail(
                email,
                type + " Usage Alert: 80%",
                "Dear " + name + ",\nYour " + type + " usage has reached 80%. Please monitor your usage."
            );
        } else if ("100".equals(threshold)) {
            sendEmail(
                email,
                type + " Usage Alert: 100%",
                "Dear " + name + ",\nYour " + type + " usage has reached 100%. Please renew your package."
            );
        }
    }

    // Main metodu
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        System.out.println("Starting Notification Service...");
        service.pollAndProcessMessages();
       
    }
}

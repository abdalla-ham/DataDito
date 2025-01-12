package com.i2i.datadito;

import com.i2i.datadito.kafka.MessageConsumer;
import com.i2i.datadito.kafka.message.NotificationMessage;

import jakarta.mail.*;
import jakarta.mail.internet.*;
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
        final String senderEmail = "i2iemailsender@gmail.com"; // Gönderici e-posta adresi
        final String senderPassword = "iikn hcld bsjq nexz"; // Gmail uygulama şifresi

        Properties emailProps = new Properties();
        emailProps.put("mail.smtp.host", "smtp.gmail.com");
        emailProps.put("mail.smtp.port", "587");
        emailProps.put("mail.smtp.auth", "true");
        emailProps.put("mail.smtp.starttls.enable", "true");
        emailProps.put("mail.debug", "true"); // SMTP debug modu

        // SMTP oturumu başlat
        Session session = Session.getInstance(emailProps, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Mesaj oluştur
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(body);

            // E-postayı gönder
            System.out.println("Sending email to: " + recipient);
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
        // Mesaj detaylarını kontrol etmek için log ekleyin
        System.out.println("Processing NotificationMessage:");
        System.out.println("Name: " + message.getName());
        System.out.println("Lastname: " + message.getLastname());
        System.out.println("Email: " + message.getEmail());
        System.out.println("Usage Type: " + message.getType());
        System.out.println("Threshold: " + message.getThreshold());

        // Threshold değerine göre e-posta gönderimi
        String recipient = message.getEmail();
        String subject = "";
        String body = "";

        if ("80".equals(message.getThreshold())) {
            subject = message.getType() + " Usage Alert: 80%";
            body = "Dear " + message.getName() + " " + message.getLastname() + ",\nYour " +
                    message.getType() + " usage has reached 80%.\nPlease monitor your usage.";
        } else if ("100".equals(message.getThreshold())) {
            subject = message.getType() + " Usage Alert: 100%";
            body = "Dear " + message.getName() + " " + message.getLastname() + ",\nYour " +
                    message.getType() + " usage has reached 100%.\nPlease renew your package.";
        } else {
            System.out.println("Threshold value is not 80 or 100. No email will be sent.");
            return; // Threshold uygun değilse e-posta gönderme
        }

        // E-posta gönderme
        sendEmail(recipient, subject, body);
    }

    // Main metodu
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        System.out.println("Starting Notification Service...");
        service.pollAndProcessMessages();
    }
}

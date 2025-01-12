package com.i2i.datadito;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class JakartaMailTest {

    public static void main(String[] args) {
        // Gönderici e-posta adresi ve uygulama şifresi
        final String senderEmail = "i2iemailsender@gmail.com"; // Gönderici Gmail adresiniz
        final String senderPassword = "iikn hcld bsjq nexz"; // Gmail uygulama şifreniz

        // Alıcı e-posta adresi
        final String recipientEmail = "recipient@example.com"; // Alıcı e-posta adresi

        // SMTP özelliklerini ayarla
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // TLS protokolü
        props.put("mail.debug", "true"); // SMTP oturumunu debug modunda göster

        // SMTP oturumunu başlat
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // E-posta mesajını oluştur
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail)); // Gönderici
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Alıcı
            message.setSubject("Test Email"); // Konu
            message.setText("This is a test email sent using Jakarta Mail API."); // Gövde

            // Mesajı gönder
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}

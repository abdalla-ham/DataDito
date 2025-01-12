package com.i2i.datadito;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailTest {

    public static void main(String[] args) {
        // Gönderici e-posta adresi ve uygulama şifresi
        final String senderEmail = "i2iemailsender@gmail.com"; // Gmail adresiniz
        final String senderPassword = "uygulama_sifreniz_buraya"; // Gmail uygulama şifresi

        // Alıcı e-posta adresi
        final String recipientEmail = "recipient@example.com"; // Alıcı e-posta adresi

        // SMTP özellikleri ayarları
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); // Güvenli bağlantı için TLS kullanımı
        props.put("mail.debug", "true"); // SMTP oturumunu loglamak için debug modu

        // SMTP oturumunu başlat
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            // Mesaj oluştur
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail)); // Gönderici adresi
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail)); // Alıcı adresi
            message.setSubject("Test Email"); // E-posta konusu
            message.setText("This is a test email sent from Java application."); // E-posta içeriği

            // E-postayı gönder
            System.out.println("Sending email...");
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}

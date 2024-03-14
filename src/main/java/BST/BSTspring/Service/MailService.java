package BST.BSTspring.Service;


import BST.BSTspring.controller.RequiredArgsConstructor;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;



@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail= "[내이메일]";
    private static int number;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public static void createNumber(){
        number = (int)(Math.random() * (90000)) + 100000;// (int) Math.random() * (최댓값-최소값+1) + 최소값
    }

    public jakarta.mail.internet.MimeMessage CreateMail(String mail){
        createNumber();
        jakarta.mail.internet.MimeMessage message = javaMailSender.createMimeMessage();

        try {
            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, mail);
            message.setSubject("이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8", "html");
        } catch (MessagingException | jakarta.mail.MessagingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public int sendMail(String mail){
        jakarta.mail.internet.MimeMessage message = CreateMail(mail);
        javaMailSender.send(message);

        return number;
    }
}

package in.ankit.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailSender {
	
	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendMailWithAttachment(String toEmail, String subject, String body, File file) throws Exception {

	        MimeMessage mimeMsg = mailSender.createMimeMessage();
	        
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMsg, true); // Use true for multi-part(attachment)
	        helper.setTo(toEmail);
	        helper.setSubject(subject);
	        helper.setText(body);
	        helper.addAttachment("plans-info", file);

	        mailSender.send(mimeMsg);

            }
	    }

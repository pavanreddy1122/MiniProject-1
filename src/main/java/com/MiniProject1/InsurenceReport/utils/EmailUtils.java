package com.MiniProject1.InsurenceReport.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean sendEmail(String subject,String body,String to,File f)
	{
		try {
			MimeMessage mime=mailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mime,true);
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			helper.addAttachment("Plans-Info",f);
			 mailSender.send(mime);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}

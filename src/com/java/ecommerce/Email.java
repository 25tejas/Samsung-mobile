package com.java.ecommerce;
import java.util.Properties;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email 
{
    String to="25tejasdalvi@gmail.com";
    String subject;
    String text;

    public Email(String to, String subject, String text) 
    {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public void sendEmail() 
    {
    	try
    	{
	        System.out.println("=============mail===========");
	        final String username = "contact.tejas.dalvi@gmail.com";
			final String password = "dalvi#123";
	
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	
			Session session = Session.getInstance(props, new javax.mail.Authenticator() 
			{
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("25tejasdalvi@gmail.com"));
			message.setSubject("hello");
			message.setText("hii");
			  	MimeMultipart multipart = new MimeMultipart("related");

		         BodyPart messageBodyPart = new MimeBodyPart();
		         String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
		         messageBodyPart.setContent(htmlText, "text/html");
		        
		         multipart.addBodyPart(messageBodyPart);

		         messageBodyPart = new MimeBodyPart();
		         DataSource fds = new FileDataSource(
		            "C:/Tejas/Projects/Photos/");

		         messageBodyPart.setDataHandler(new DataHandler(fds));
		         messageBodyPart.setHeader("Content-ID", "<image>");

		         multipart.addBodyPart(messageBodyPart);

		         message.setContent(multipart);
			Transport.send(message);
			
			System.out.println("Done");
    	}
    	catch (Exception e)
    	{
    		System.out.println(e);
		}
    }
   
}
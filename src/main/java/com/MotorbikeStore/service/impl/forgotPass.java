package com.MotorbikeStore.service.impl;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.MotorbikeStore.dao.impl.forgotPassDAO;


public class forgotPass 
{
	private forgotPassDAO checkMailExist = new forgotPassDAO();
	public int sendOTP(String email)
	{
		if (checkMailExist.checkExistEmail(email))	
		{
			// sending otp
			Random rand = new Random();
			int otpvalue = rand.nextInt(1255650);
	
			String to = email;// change accordingly
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.socketFactory.port", "465"); 
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.port", "465"); //TLS Port
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() 
			{
				protected PasswordAuthentication getPasswordAuthentication() 
				{
						return new PasswordAuthentication("tnhubh@gmail.com", "lsyvwtzpirhvjorj");// Put your email
																										// id and
																										// password here
				}
			});
			// compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));// change accordingly
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("Reset Your Password");
				message.setText("Your OTP is: " + otpvalue);
				// send message
				Transport.send(message);
				System.out.println("Message sent successfully");
				return otpvalue;
			}
			catch (MessagingException e) 
			{
				
				return -1;
			}
		}
		else 
		{
			return 0;
		}
	}
	
}

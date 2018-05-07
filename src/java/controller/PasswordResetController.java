package controller;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class PasswordResetController extends AbstractController {
    
    public PasswordResetController() {
    }
    
    @Override
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        
        Random r = new Random();
        int x = r.nextInt(1000) + 1; //random number between 1 and 1000
        //next generate a random hash 
        //save hash, email and expiry date in DB
        //now send mail
        
        String to = request.getParameter("email");
        String subject = "Change your password";
        String msg = "To change password click me "+"http://localhost:8080/PasswordResetSpring/password.htm?r="+x;
        
        final String from = "pandeylokprakash@gmail.com";
        final String password = ".......";

            //Get properties object    
          Properties props = new Properties();    
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.starttls.enable", "true");
            
            //SSL gives problem with gmail...avoid it              
//          props.put("mail.smtp.host", "smtp.gmail.com");    
//          props.put("mail.smtp.socketFactory.port", "465");    
//          props.put("mail.smtp.socketFactory.class",    
//                    "javax.net.ssl.SSLSocketFactory");    
//          props.put("mail.smtp.auth", "true");    
//          props.put("mail.smtp.port", "465");   
          

          //get Session   
          Session session = Session.getInstance(props,    
           new Authenticator() {    
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }
           });    
          
          
          
          try {  
             MimeMessage message = new MimeMessage(session);  
             message.setFrom(new InternetAddress(from));  
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
             message.setSubject(subject);  
             message.setText(msg);  
             Transport.send(message);
             } catch (Exception e) {  
                    e.printStackTrace();
             }  
        
        return new ModelAndView("emailsent","user_message",to);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import Service.ServiceUser;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author mouad
 */
public class Mailling_actualite {
     public static void sendMail(String id_actualite) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "maitressecole13@gmail.com";
        //Your gmail password
        String password = "ghadaarbia123456";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        ServiceUser su = new ServiceUser();
        List<String> mail_list = su.get_mailing_list();
         for (String recepient : mail_list) {
            //Prepare email message
            Message message = prepareMessage(session, myAccountEmail, recepient, id_actualite);

            //Send mail
            Transport.send(message);
            System.out.println("Message sent successfully to "+recepient);
         }
    }

     
     private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String id_actualite) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Actualit?? ajout??e!");
            String htmlCode = "<h1> Cin??Jamil </h1> <br/> <h2><b>Une nouvelle actualit?? a ??t?? ajout??e "
                    + "<br>Pour plus d'informations, veuillez vous connecter sur notre application! </b></h2>";
            message.setContent(htmlCode, "text/html");
            message.addHeader("Content-ID", "My_image");
            //imagePart.setDisposition(MimeBodyPart.INLINE);

            return message;
        } catch (Exception ex) {
            Logger.getLogger(Mailling_actualite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}

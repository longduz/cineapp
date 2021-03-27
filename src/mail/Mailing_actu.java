/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;

import Entities.Actualite;
import Entities.Film;
import Entities.Promotion;
import Service.ServiceActualite;
import Service.ServiceFilm;
import Service.ServicePromotion;
import Service.ServiceUser;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author amine
 */
public class Mailing_actu {
    public static void sendMail(String id_actualite) throws Exception {
        String host = "smtp.gmail.com";
        String port = "587";
        String userName = "maitressecole13@gmail.com";
        String password = "ghadaarbia123456";
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", password);
        
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        
        Session session = Session.getInstance(properties, auth);
        
        ServiceActualite sa = new ServiceActualite();
        Actualite actu = sa.get_actualite_by_id(Integer.valueOf(id_actualite));
        ServiceFilm sf = new ServiceFilm();
        Film film = sf.get_film_by_id(actu.getId_film());
        ServicePromotion sp = new ServicePromotion();
        Promotion promotion = sp.get_promotion_by_id(actu.getId_film());
            
        ServiceUser su = new ServiceUser();
        List<String> mail_list = su.get_mailing_list();
        for (String toAddress : mail_list) {
            // creates a new e-mail message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(userName));
            InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
            msg.setRecipients(Message.RecipientType.TO, toAddresses);
            msg.setSubject("Actualité ajoutée!");
            msg.setSentDate(new Date());
            
            // creates message part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String htmlBody = "<h1> CinéJamil: Une nouvelle actualité a été ajoutée</h1> <img src=\"cid:"+film.getImage()+"\" /> "
                    + "<br><h2>Description:" + actu.getDescription() + " </b>"
                    + "<br>Remise:" + String.valueOf(promotion.getPercent()) + "% </b></h2>"
                    + "<br>Pour plus d'informations, veuillez vous connecter sur notre application! </b>";
            messageBodyPart.setContent(htmlBody, "text/html");
            
            // creates multi-part
            Multipart multipart = new MimeMultipart("related");
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.setHeader("Content-ID", "<" + film.getImage() + ">");
            imagePart.setDisposition(MimeBodyPart.INLINE);
            //set imageFilePath
            try {
                imagePart.attachFile("E:/aio210/CineApp/CineApp/src/images/"+film.getImage());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            multipart.addBodyPart(imagePart);

            msg.setContent(multipart);
 
            Transport.send(msg);
        }
    }
}

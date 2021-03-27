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
import Utils.Maconnexion;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author AMINE
 */
public class PDFutil {

    Connection cn2;
    Statement ste;
    ServiceActualite sa = new ServiceActualite();
    ServiceFilm sf = new ServiceFilm();
    ServicePromotion sp = new ServicePromotion();

    public PDFutil() {
        cn2 = Maconnexion.getInstance().getConnection();
    }

    public void get_pdf(String id_actualite) throws SQLException, FileNotFoundException, IOException {
        Actualite actu = sa.get_actualite_by_id(Integer.valueOf(id_actualite));
        Film film = sf.get_film_by_id(actu.getId_film());
        Promotion promotion = sp.get_promotion_by_id(actu.getId_film());
        //Document document = new Document();

        java.util.Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss");
        String strDate = dateFormat.format(date);
        // Creating a PdfWriter
        String dest = "E:/aio210/CineApp/CineApp/id_actualite_" + id_actualite + "_" + strDate + ".pdf";
        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument       
        PdfDocument pdf = new PdfDocument(writer);
        // Creating a Document        
        Document document = new Document(pdf);
        
        Paragraph ph1 = new Paragraph("Bienvenue à CineApp !");
        document.add(ph1);

        ph1 = new Paragraph("Chez CineApp, il y a toujours de l'actualié ;) ");
        document.add(ph1);

        String imageFile = "E:/aio210/CineApp/CineApp/src/images/" + film.getImage();
        ImageData data = ImageDataFactory.create(imageFile);
        Image img = new Image(data);
        document.add(img);

        ph1 = new Paragraph("Description: " + actu.getDescription());
        document.add(ph1);

        ph1 = new Paragraph("Promotion: " + String.valueOf(promotion.getPercent()) + "%");
        document.add(ph1);
        
        document.close();
    }
}

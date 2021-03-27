/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import Entities.Actualite;
import Service.ServiceActualite;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mail.Mailing_actu;
import mail.Mailling_actualite;

/**
 *
 * @author mouad
 */
public class AjouterActuController implements Initializable {
    Connection cnx;
    private int idUser;
    
    ServiceActualite sa = new ServiceActualite();
    @FXML
    private TextField idfilmActu;
    @FXML
    private TextField idpromActu;
    @FXML
    private DatePicker dateActu;
    @FXML
    private TextArea descriptionActu;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // controle de saisie date >= date aujourd'hui
        dateActu.valueProperty().addListener((e) -> {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            if (dateActu.getValue().toString().compareTo(dateFormat.format(date)) < 0) {
                Alert a = new Alert(Alert.AlertType.ERROR, "Entrer une date valide", ButtonType.OK);
                a.showAndWait();
            }
        });
    }

    @FXML
    private void confirmer(ActionEvent event) throws IOException, SQLException, Exception {
        if (dateActu.getValue() == null || idfilmActu.getText() == null || idpromActu.getText() == null || descriptionActu.getText() == null) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Veuillez remplir tous les champs", ButtonType.OK);
            a.showAndWait();
        } else {
            
            LocalDate localDate = dateActu.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            java.util.Date date = Date.from(instant);
            java.sql.Date dtSql = new java.sql.Date(date.getTime());
            
            int id_film = Integer.valueOf(idfilmActu.getText());
            int id_prom = Integer.valueOf(idpromActu.getText());
            
            Actualite actu = new Actualite(dtSql, descriptionActu.getText(), id_film, id_prom);
            
            Mailing_actu.sendMail(sa.ajouter_actualite(actu));
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
            Parent root = loader.load();
            descriptionActu.getScene().setRoot(root);
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        descriptionActu.getScene().setRoot(root);
    }


}

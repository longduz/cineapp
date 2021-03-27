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
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Amine
 */
public class ModifierActuController implements Initializable {

    @FXML
    private TextField idfilmActu;
    @FXML
    private TextField idpromActu;
    @FXML
    private DatePicker dateActu;
    @FXML
    private TextArea descriptionActu;
    
    public static Actualite actu;
    
    ServiceActualite sa = new ServiceActualite();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idfilmActu.setText(String.valueOf(actu.getId_film()));
        idpromActu.setText(String.valueOf(actu.getId_prom()));
        dateActu.setValue(actu.getDate().toLocalDate());
        descriptionActu.setText(String.valueOf(actu.getDescription()));
        // TODO
    }    

    @FXML
    private void confirmer(ActionEvent event) throws IOException, SQLException {
        LocalDate localDate = dateActu.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        java.util.Date date = Date.from(instant);
        java.sql.Date dtSql = new java.sql.Date(date.getTime());

        int id_film = Integer.valueOf(idfilmActu.getText());
        int id_prom = Integer.valueOf(idpromActu.getText());

        Actualite actualite = new Actualite(dtSql, descriptionActu.getText(), id_film, id_prom);
        sa.update_actualite(actualite, actu.getId_act());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        descriptionActu.getScene().setRoot(root);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChercherActu.fxml"));
        Parent root = loader.load();
        descriptionActu.getScene().setRoot(root);
    }
    
}

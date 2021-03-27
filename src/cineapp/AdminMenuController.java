/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import Entities.Reservation;
import Service.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author mouad
 */
public class AdminMenuController implements Initializable {
    Connection cnx;
    private int idUser;
    @FXML
    private Button btAjoutActu;
    @FXML
    private Button btModifActu;
    @FXML
    private Button btSuppActu;
    @FXML
    private Button btShowActu;
    @FXML
    private ImageView backgroun;
    @FXML
    private Button btExportActu1;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void AjouterActu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterActu.fxml"));
        Parent root = loader.load();
        btSuppActu.getScene().setRoot(root);
    }    

    @FXML
    private void ModifierActu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChercherActu.fxml"));
        Parent root = loader.load();
        btSuppActu.getScene().setRoot(root);
    }    

    @FXML
    private void SupprimerActu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerActu.fxml"));
        Parent root = loader.load();
        btSuppActu.getScene().setRoot(root);
    }    

    @FXML
    private void AfficherActu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AffichageActu.fxml"));
        Parent root = loader.load();
        btSuppActu.getScene().setRoot(root);
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) btShowActu.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void ExporterPDF(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ExporterActuPDF.fxml"));
        Parent root = loader.load();
        btSuppActu.getScene().setRoot(root);
        
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import Entities.Reservation;
import Service.ServiceActualite;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author mouad
 */
public class SupprimerActuController implements Initializable {
    Connection cnx;
    private int idUser;
    @FXML
    private TextField tfIdResSupprimerRes;
    @FXML
    private Button btSupprimerActu;
    
    ServiceActualite sa = new ServiceActualite();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void SupprimerActu(ActionEvent event) throws SQLException, IOException {
        sa.delete_actualite_by_id(Integer.valueOf(tfIdResSupprimerRes.getText()));
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        btSupprimerActu.getScene().setRoot(root);
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        btSupprimerActu.getScene().setRoot(root);
    }


}

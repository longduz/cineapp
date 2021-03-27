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
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 *
 * @author mouad
 */
public class ChercherActuController implements Initializable {
    Connection cnx;
    private int idUser;
    
    ServiceActualite sa = new ServiceActualite();
    @FXML
    private TextField idActualite;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void ChercherActu(ActionEvent event) throws IOException, SQLException {
        Actualite actu = sa.get_actualite_by_id(Integer.valueOf(idActualite.getText()));
        if (actu != null){
            ModifierActuController controller = new ModifierActuController();
            controller.actu = actu;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierActu.fxml"));
            Parent root = loader.load();
            idActualite.getScene().setRoot(root);  
        }
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        idActualite.getScene().setRoot(root);
        
    }
}

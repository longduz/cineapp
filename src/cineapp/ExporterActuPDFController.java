/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import mail.PDFutil;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class ExporterActuPDFController implements Initializable {

    @FXML
    private Button btExporterActu;
    @FXML
    private TextField id_actu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void Retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        btExporterActu.getScene().setRoot(root);
    }

    @FXML
    private void ExporterActu(ActionEvent event) throws SQLException, IOException {
        PDFutil pdfutil = new PDFutil();
        pdfutil.get_pdf(id_actu.getText());
        Alert alert=new Alert(Alert.AlertType.WARNING);
        alert.setTitle("creation page pd");
        alert.setHeaderText(null);
        alert.setContentText("creation du fichier pdf avec succées"); 
        alert.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        btExporterActu.getScene().setRoot(root);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import Entities.Actualite;
import Entities.Reservation;
import Service.ServiceActualite;
import Service.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author mouad
 */
public class AffichageActuController implements Initializable {
    Connection cnx;
    private int idUser;
    private Button btSuppActu;
    private Button btShowActu;
    @FXML
    private ImageView backgroun;
    @FXML
    private TableColumn<Actualite, Integer> id_act;
    @FXML
    private TableColumn<Actualite, String> date;
    @FXML
    private TableColumn<Actualite, String> description;
    @FXML
    private TableColumn<Actualite, Integer> id_film;
    @FXML
    private TableColumn<Actualite, Integer> id_prom;
    @FXML
    private TableColumn<Actualite, Integer> id_admin;
    @FXML
    private TableView<Actualite> table;
    
    ServiceActualite sa = new ServiceActualite();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Actualite> observableList = null;
        try {
            observableList = FXCollections.observableArrayList(sa.get_actualite());
            table.setItems(observableList);
        } catch (SQLException ex) {
            Logger.getLogger(AffichageActuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setItems(observableList);
        
        id_act.setCellValueFactory(new PropertyValueFactory<>("id_act"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        id_film.setCellValueFactory(new PropertyValueFactory<>("id_film"));
        id_prom.setCellValueFactory(new PropertyValueFactory<>("id_prom"));
        id_admin.setCellValueFactory(new PropertyValueFactory<>("id_admin"));

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminMenu.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
    }

}
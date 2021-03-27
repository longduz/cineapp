/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cineapp;

import Entities.Actualite;
import Entities.Film;
import Entities.Promotion;
import Service.ServiceActualite;
import Service.ServiceFilm;
import Service.ServicePromotion;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author amine
 */
public class UserMenuController implements Initializable {

    @FXML
    private ImageView backgroun;
    @FXML
    private ImageView image_film;
    @FXML
    private TextArea description_film;
    @FXML
    private Button film_precedent;
    @FXML
    private TextField reduction_film;
    @FXML
    private Button film_suivant;
    
    ServiceActualite sa = new ServiceActualite();
    ServiceFilm sf = new ServiceFilm();
    ServicePromotion sp = new ServicePromotion();
    @FXML
    private TextField current_film_id;
    private int ActuCount = 0;
    List<Actualite> arr = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            arr = sa.get_actualite();
            Actualite myactu = arr.get(0);
            Film myfilm = sf.get_film_by_id(myactu.getId_film());
            Promotion mypromotion = sp.get_promotion_by_id(myactu.getId_prom());
            String image_url = "/images/" +myfilm.getImage();
            image_film.setImage(new Image(image_url));
            description_film.setText(myactu.getDescription());
            reduction_film.setText(String.valueOf(mypromotion.getPercent()));
        } catch (SQLException ex) {
            Logger.getLogger(UserMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    


    @FXML
    private void close(ActionEvent event) {
    }

    @FXML
    private void get_previous_film(ActionEvent event) throws SQLException {
        ActuCount = ActuCount - 1;
        if (ActuCount < 0) {
            ActuCount = arr.size() - 1;
        }
        Actualite myactu = arr.get(ActuCount);
        Film myfilm = sf.get_film_by_id(myactu.getId_film());
        Promotion mypromotion = sp.get_promotion_by_id(myactu.getId_prom());
        String image_url = "/images/" +myfilm.getImage();
        image_film.setImage(new Image(image_url));
        description_film.setText(myactu.getDescription());
        reduction_film.setText(String.valueOf(mypromotion.getPercent()));
    }

    @FXML
    private void get_next_film(ActionEvent event) throws SQLException {
        ActuCount = ActuCount + 1;
        if (ActuCount == arr.size()) {
            ActuCount = 0;
        }
        Actualite myactu = arr.get(ActuCount);
        Film myfilm = sf.get_film_by_id(myactu.getId_film());
        Promotion mypromotion = sp.get_promotion_by_id(myactu.getId_prom());
        String image_url = "/images/" +myfilm.getImage();
        image_film.setImage(new Image(image_url));
        description_film.setText(myactu.getDescription());
        reduction_film.setText(String.valueOf(mypromotion.getPercent()));
    }
    
}

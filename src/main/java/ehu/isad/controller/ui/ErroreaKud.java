package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.ErroreaDBKud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private EurovisionEIB main;

    @FXML
    private Label lblLabela;

    @FXML
    private Button btnBotoia;

    @FXML
    private ImageView imgBandera;

    @FXML
    void onClick(ActionEvent event) {
        main.herrialdeakHautatuErakutsi();
    }


    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    public void labelIdatzi(String herrialdea){
        lblLabela.setText(herrialdea+" jada banatu ditu bere puntuak");
    }

    public void banderaJarri(String herrialdea){
        imgBandera.setImage(this.irudiaLortu(herrialdea));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    private Image irudiaLortu(String herrialdea) {

        Image image = null;
        image = new Image(getClass().getResourceAsStream("/"+ErroreaDBKud.getInstance().lortuHerrialdearenBandera(herrialdea)+".png"));
        return image;

    }
    }

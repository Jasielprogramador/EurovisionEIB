package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ErroreaKud implements Initializable {

    private EurovisionEIB main;

    @FXML
    private Label lblLabela;

    @FXML
    private Button btnBotoia;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    }

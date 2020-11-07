package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.HerrialdeaHautatuDBKud;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class HerrialdeaHautatuKud implements Initializable {

    private EurovisionEIB main;

    @FXML
    public ComboBox<String> comboHerrialdeak;

    @FXML
    private Button btnBotoia;

    @FXML
    private ImageView imgIrudia;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    @FXML
    void onClick(ActionEvent event) {

        int puntuak = HerrialdeaHautatuDBKud.getInstance().lortuHerrialdeBatenPuntuak(comboHerrialdeak.getValue());

        if(puntuak>=5){
            main.getErroreaKud().labelIdatzi(comboHerrialdeak.getValue());
            main.getErroreaKud().banderaJarri(comboHerrialdeak.getValue());
            main.erroreaErakutsi();
        }
        else{
            main.getHerrialdeaBozkatuKud().labelIdatzi(comboHerrialdeak.getValue());
            main.getHerrialdeaBozkatuKud().banderaJarri(comboHerrialdeak.getValue());
            main.getHerrialdeaBozkatuKud().comboBalioaLortu(comboHerrialdeak.getValue());
            main.herrialdeaBozkatuErakutsi();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> herrialdeak = FXCollections.observableArrayList();
        herrialdeak.addAll(HerrialdeaHautatuDBKud.getInstance().lortuHerrialdeak());

        comboHerrialdeak.setItems(herrialdeak);
        comboHerrialdeak.getSelectionModel().selectFirst();
        comboHerrialdeak.setEditable(false);
    }

}

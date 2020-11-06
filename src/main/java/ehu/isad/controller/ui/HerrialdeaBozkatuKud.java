package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.ErroreaDBKud;
import ehu.isad.controller.db.HerrialdeaBozkatuDBKud;
import ehu.isad.partaideak.Partaidea;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;

public class HerrialdeaBozkatuKud implements Initializable {

    private EurovisionEIB main;

    @FXML
    private Label lblLabela;

    @FXML
    private ImageView imgBandera;

    @FXML
    private Button btnBotoia;

    @FXML
    private TableView<Partaidea> tblTaula;

    @FXML
    private TableColumn<Partaidea, Image> tblBandera;

    @FXML
    private TableColumn<Partaidea, String> tblHerrialdea;

    @FXML
    private TableColumn<Partaidea, String> tblArtista;

    @FXML
    private TableColumn<Partaidea, String> tblAbestia;

    @FXML
    private TableColumn<Partaidea, Integer> tblPuntuak;



    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    public void labelIdatzi(String herrialdea) {
        lblLabela.setText(herrialdea + "k horrela nahi ditu bere puntuak banatu:");
    }

    @FXML
    void onClick(ActionEvent event) {
        this.main.top3Erakutsi();
    }
/*
    private boolean herrialdeEzinBozkatu(){
        if(.equals(main.getComboBalioa())){
            return true;
        }
        else{
            return false;
        }
    }*/

    private Image irudiaLortu(String herrialdea) {

        Image image = null;
        image = new Image(getClass().getResourceAsStream("/"+HerrialdeaBozkatuDBKud.getInstance().lortuHerrialdearenBandera(herrialdea)+".png"));
        return image;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*String herrialdea = main.getComboBalioa();
        imgBandera.setImage(this.irudiaLortu(herrialdea));*/

        HerrialdeaBozkatuDBKud herrialdeaBozkatuDBKud = new HerrialdeaBozkatuDBKud();
        List<Partaidea> kargatzekoa = herrialdeaBozkatuDBKud.bozkatzekoHerrialdeakKargatu();
        ObservableList<Partaidea> Partaideak = FXCollections.observableArrayList(kargatzekoa);

        //add your data to the table here.
        tblTaula.setItems(Partaideak);
        tblTaula.setEditable(true);


        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class

        tblBandera.setCellValueFactory(new PropertyValueFactory<>("Bandera"));
        tblHerrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        tblArtista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        tblAbestia.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
        tblPuntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));


        //if(!this.herrialdeEzinBozkatu()){
            tblPuntuak.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        //}

        tblPuntuak.setOnEditCommit(
                t -> {
                   // if(!this.herrialdeEzinBozkatu()) {
                        t.getTableView().getItems().get(t.getTablePosition().getRow())
                                .setPuntuak(t.getNewValue());
                 //   }
                });

        //Irudia kargatzeko
        tblBandera.setCellFactory(p -> new TableCell<>() {
            public void updateItem(Image image, boolean empty) {
                if (image != null && !empty){
                    final ImageView imageview = new ImageView();
                    imageview.setFitHeight(50);
                    imageview.setFitWidth(50);
                    imageview.setImage(image);
                    setGraphic(imageview);
                    setAlignment(Pos.CENTER);
                    // tbData.refresh();
                }else{
                    setGraphic(null);
                    setText(null);
                }
            };
        });

    }
}





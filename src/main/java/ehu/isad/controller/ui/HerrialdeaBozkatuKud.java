package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
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

import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.List;

public class HerrialdeaBozkatuKud implements Initializable {

    private EurovisionEIB main;

    @FXML
    private Label lblLabel;

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

    public void labelIdatzi(String herrialdea){
        lblLabel.setText(herrialdea+"k horrela nahi ditu bere puntuak banatu:");
    }

    @FXML
    void onClick(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HerrialdeaBozkatuDBKud herrialdeaBozkatuDBKud = new HerrialdeaBozkatuDBKud();
        List<Partaidea> kargatzekoa=herrialdeaBozkatuDBKud.bozkatzekoHerrialdeakKargatu();
        ObservableList<Partaidea> Partaideak = FXCollections.observableArrayList(kargatzekoa);

        tblTaula.setEditable(true);
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tblBandera.setCellValueFactory(new PropertyValueFactory<>("Bandera"));
        tblHerrialdea.setCellValueFactory(new PropertyValueFactory<>("Herrialdea"));
        tblArtista.setCellValueFactory(new PropertyValueFactory<>("Artista"));
        tblAbestia.setCellValueFactory(new PropertyValueFactory<>("Abestia"));
        tblPuntuak.setCellValueFactory(new PropertyValueFactory<>("Puntuak"));


        Callback<TableColumn<Partaidea, String>, TableCell<Partaidea, String>> defaultTextFieldCellFactory
                = TextFieldTableCell.<Partaidea>forTableColumn();

        tblBandera.setCellValueFactory(new PropertyValueFactory<Partaidea, Image>("bandera"));

        tblBandera.setCellFactory(p -> new TableCell<>() {
            private void updateItem(javafx.scene.image.Image image, boolean empty) {
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

        tblHerrialdea.setCellFactory(col -> {
            TableCell<Partaidea, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    cell.setEditable(false);
                }
            });

            return cell ;
        });

        tblArtista.setCellFactory(col -> {
            TableCell<Partaidea, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    cell.setEditable(false);
                }
            });

            return cell ;
        });

        tblAbestia.setCellFactory(col -> {
            TableCell<Partaidea, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                if (! cell.isEmpty()) {
                    cell.setEditable(false);
                }
            });

            return cell ;
        });

        tblPuntuak.setCellFactory(
                TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tblPuntuak.setOnEditCommit(
                t -> {
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setPuntuak(t.getNewValue());
                }
        );

        tblArtista.setCellFactory(col -> {
            TableCell<Partaidea, String> cell = defaultTextFieldCellFactory.call(col);

            cell.setOnMouseClicked(event -> {
                cell.setEditable(true);

            });

            return cell ;
        });

        //add your data to the table here.
        tblTaula.setItems(Partaideak);
    }





}

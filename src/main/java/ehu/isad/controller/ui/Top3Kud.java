package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.controller.db.Top3DBKud;
import ehu.isad.partaideak.Partaidea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Top3Kud implements Initializable {

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Button btnBotoia;

    private EurovisionEIB main;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }


    @FXML
    void onClick(ActionEvent event) {
        this.main.hasieraErakutsi();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Partaidea> top = Top3DBKud.getInstance().top3Lortu();
        img1.setImage(top.get(2).getBandera());
        lbl1.setText(top.get(2).getHerrialdea()+"-"+top.get(2).getPuntuak());

        img2.setImage(top.get(1).getBandera());
        lbl2.setText(top.get(1).getHerrialdea()+"-"+top.get(1).getPuntuak());

        img3.setImage(top.get(0).getBandera());
        lbl3.setText(top.get(0).getHerrialdea()+"-"+top.get(0).getPuntuak());
    }
}


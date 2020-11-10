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
        img1.setImage(top.get(0).getBandera());
        lbl1.setText(top.get(0).getHerrialdea()+"-"+top.get(0).getPuntuak());

        int i=1;
        while(top.get(0).getHerrialdea().equals(top.get(i).getHerrialdea())){
            i++;
        }
        img2.setImage(top.get(i).getBandera());
        lbl2.setText(top.get(i).getHerrialdea()+"-"+top.get(i).getPuntuak());

        int j=2;
        while(top.get(i).getHerrialdea().equals(top.get(j).getHerrialdea()) ||
                top.get(0).getHerrialdea().equals(top.get(j).getHerrialdea())){
            j++;
        }
        img3.setImage(top.get(j).getBandera());
        lbl3.setText(top.get(j).getHerrialdea()+"-"+top.get(i).getPuntuak());
    }
}


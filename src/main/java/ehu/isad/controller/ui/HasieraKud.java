package ehu.isad.controller.ui;

import ehu.isad.EurovisionEIB;
import ehu.isad.utils.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import ehu.isad.utils.Utils;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class HasieraKud implements Initializable {

    private EurovisionEIB main;

    public void setMainApp(EurovisionEIB main) {
        this.main = main;
    }

    @FXML
    private Button btn_bozkatu;

    @FXML
    private ImageView imgIrudia;

    @FXML
    void klikEgin(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgIrudia.setImage(setIcon("/resources/hasiera.png"));
    }

    public ImageView setIcon(String path) {

        InputStream is=Utils.class
                .getResourceAsStream(path);
        ImageView iv = new ImageView(new Image(is));

        iv.setFitWidth(100);
        iv.setFitHeight(100);
        Image image = SwingFXUtils.toFXImage(iv, null);
        return image;
    }
}

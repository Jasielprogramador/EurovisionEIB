package ehu.isad.controller.db;

import ehu.isad.partaideak.Partaidea;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HerrialdeaBozkatuDBKud {

    private static final HerrialdeaBozkatuDBKud instance = new HerrialdeaBozkatuDBKud();

    public static HerrialdeaBozkatuDBKud getInstance() {
        return instance;
    }


    public String lortuHerrialdearenBandera(String herrialdea){
        String query = "select bandera from Herrialde where Herrialde.izena="+herrialdea;
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);
        String bandera="";

        try {
            while (rs.next()) {
                bandera = rs.getString("bandera");
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return bandera;
    }

    public List<Partaidea> bozkatzekoHerrialdeakKargatu(){

        String query = "select Ordezkaritza.*, Herrialde.bandera from Ordezkaritza inner join Herrialde where herrialdea=izena";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

            List<Partaidea> emaitza = new ArrayList<>();

            try {
                while (rs.next()) {

                    String artista = rs.getString("artista");
                    String herrialdea = rs.getString("herrialdea");
                    String abestia = rs.getString("abestia");
                    Integer puntuak = rs.getInt("puntuak");
                    String bandera = rs.getString("bandera");
                    emaitza.add(this.partaideakKargatu(artista,herrialdea,abestia,puntuak,bandera));
                }
            } catch(SQLException throwables){
                throwables.printStackTrace();
            }

            return emaitza;
        }

    private Partaidea partaideakKargatu(String artista, String herrialdea, String abestia, Integer puntuak, String bandera) {
        Image irudia = this.irudiaLortu(bandera);
        Partaidea partaidea = new Partaidea(irudia,herrialdea,artista,abestia,puntuak);
        return partaidea;
    }

    private Image irudiaLortu(String bandera) {

        Image image = null;
        image = new Image(getClass().getResourceAsStream("/"+bandera+".png"));
        return image;

    }
}

package ehu.isad.controller.db;

import ehu.isad.controller.ui.Top3Kud;
import ehu.isad.partaideak.Partaidea;
import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Top3DBKud {

    private static final Top3DBKud instance = new Top3DBKud();

    public static Top3DBKud getInstance() {
        return instance;
    }

    public List<Partaidea> top3Lortu(){
        String query="select Bozkaketa.bozkatuaIzanDa,Bozkaketa.puntuak,Herrialde.bandera from Bozkaketa inner join Herrialde where bozkatuaIzanDa=izena order by puntuak";
        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet rs=dbKudeatzaile.execSQL(query);
        Partaidea partaidea=null;
        List<Partaidea> emaitza = new ArrayList<>();

        try {
            while (rs.next()) {
                int puntuak=rs.getInt("puntuak");
                String bandera = rs.getString("bandera");
                String herrialdea=rs.getString("bozkatuaIzanDa");
                partaidea=new Partaidea(this.irudiaLortu(bandera),herrialdea,null,null,puntuak);
                emaitza.add(partaidea);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }

    private Image irudiaLortu(String bandera) {

        Image image = null;
        image = new Image(getClass().getResourceAsStream("/"+bandera+".png"));
        return image;

    }

}

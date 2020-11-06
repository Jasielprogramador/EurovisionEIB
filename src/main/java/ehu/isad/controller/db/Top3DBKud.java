package ehu.isad.controller.db;

import ehu.isad.controller.ui.Top3Kud;
import ehu.isad.partaideak.Partaidea;

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
        String query="select bozkatuaIzanDa,puntuak from Bozkaketa order by puntuak";
        DBKudeatzaile dbKudeatzaile=DBKudeatzaile.getInstantzia();
        ResultSet rs=dbKudeatzaile.execSQL(query);
        Partaidea partaidea=null;
        List<Partaidea> emaitza = new ArrayList<>();

        try {
            while (rs.next()) {
                int puntuak=rs.getInt("puntuak");
                String herrialdea=rs.getString("bozkatuaIzanDa");
                partaidea=new Partaidea(null,herrialdea,null,null,puntuak);
                emaitza.add(partaidea);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;
    }

}

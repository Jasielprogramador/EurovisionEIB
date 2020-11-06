package ehu.isad.controller.db;

import ehu.isad.partaideak.Partaidea;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ErroreaDBKud {
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
}

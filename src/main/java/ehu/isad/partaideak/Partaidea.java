package ehu.isad.partaideak;

import javafx.scene.image.Image;

public class Partaidea {

    private Image bandera;
    private String herrialdea;
    private String artista;
    private String abestia;
    private int puntuak;

    public Partaidea(Image bandera, String herrialdea, String artista, String abestia, int puntuak) {
        this.bandera = bandera;
        this.herrialdea = herrialdea;
        this.artista = artista;
        this.abestia = abestia;
        this.puntuak = puntuak;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbestia() {
        return abestia;
    }

    public void setAbestia(String abestia) {
        this.abestia = abestia;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }
}

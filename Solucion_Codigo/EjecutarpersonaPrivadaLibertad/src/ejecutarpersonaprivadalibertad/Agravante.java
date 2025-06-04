package ejecutarpersonaprivadalibertad;

import java.io.Serializable;

public class Agravante implements Serializable {

    private String nomAgra;
    private int diasAdio;
    private String nivelSegu;

    public Agravante(String nomAgra, int diasAdio, String nivelSegu) {
        this.nomAgra = nomAgra;
        this.diasAdio = diasAdio;
        this.nivelSegu = nivelSegu;
    }

    public String getNomAgra() {
        return nomAgra;
    }

    public void setNomAgra(String nomAgra) {
        this.nomAgra = nomAgra;
    }

    public int getDiasAdio() {
        return diasAdio;
    }

    public void setDiasAdio(int diasAdio) {
        this.diasAdio = diasAdio;
    }

    public String getNivelSegu() {
        return nivelSegu;
    }

    public void setNivelSegu(String nivelSegu) {
        this.nivelSegu = nivelSegu;
    }
}


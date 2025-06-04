package ejecutarpersonaprivadalibertad;

import java.io.Serializable;

public class Delito implements Serializable {
    private String nombre;
    private int diasConde;

    public Delito(String nombre, int diasConde) {
        this.nombre = nombre;
        this.diasConde = diasConde;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDiasConde() {
        return diasConde;
    }

    public void setDiasConde(int diasConde) {
        this.diasConde = diasConde;
    }
}



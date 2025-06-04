package ejecutarpersonaprivadalibertad;

import java.io.Serializable;
import java.util.ArrayList;

public class personaPrivadaLibertad implements Serializable {
    private String nombre;
    private String cedula;
    private String sexo;
    private String discapacidad;
    private int edad;
    private String nivelSeguridad;
    private String fechaIngreso;
    private ArrayList<Delito> delitos;
    private ArrayList<Agravante> agravantes;

    public personaPrivadaLibertad(String nombre, String cedula, String sexo, String discapacidad, int edad, String nivelSeguridad, String fechaIngreso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.sexo = sexo;
        this.discapacidad = discapacidad;
        this.edad = edad;
        this.nivelSeguridad = nivelSeguridad;
        this.fechaIngreso = fechaIngreso;
        this.delitos = new ArrayList<>();
        this.agravantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(String nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public ArrayList<Delito> getDelitos() {
        return delitos;
    }

    public void setDelitos(ArrayList<Delito> delitos) {
        this.delitos = delitos;
    }

    public ArrayList<Agravante> getAgravantes() {
        return agravantes;
    }

    public void setAgravantes(ArrayList<Agravante> agravantes) {
        this.agravantes = agravantes;
    }

    public void agregarDelito(Delito delito) {
        delitos.add(delito);
    }

    public void agregarAgravante(Agravante agravante) {
        agravantes.add(agravante);
    }

    public int getDiasVisita() {
        int dias = 4;
        for (int i = 0; i < agravantes.size(); i++) {
            Agravante a = agravantes.get(i);
            if (a.getNivelSegu().equalsIgnoreCase("Leve")) {
                dias = dias - 1;
                if (dias < 0) {
                    dias = 0;
                }
            }
        }
        return dias;
    }

    public int getPenaTotal() {
        int total = 0;
        for (int i = 0; i < delitos.size(); i++) {
            Delito d = delitos.get(i);
            total = total + d.getDiasConde();
        }

        for (int i = 0; i < agravantes.size(); i++) {
            Agravante a = agravantes.get(i);
            if (a.getNivelSegu().equalsIgnoreCase("Grave") || a.getNivelSegu().equalsIgnoreCase("Muy Grave")) {
                total = total + a.getDiasAdio();
            }
        }
        return total;
    }

    public String toString() {
        String info = "Nombre: " + nombre +
                      "\nCedula: " + cedula +
                      "\nSexo: " + sexo +
                      "\nDiscapacidad: " + discapacidad +
                      "\nEdad: " + edad +
                      "\nNivel de seguridad: " + nivelSeguridad +
                      "\nFecha de ingreso: " + fechaIngreso +
                      "\nDias de visita permitidos: " + getDiasVisita() +
                      "\nPena total: " + getPenaTotal() + " dias\n" +
                      "Delitos:";

        if (delitos.size() == 0) {
            info = info + " Ninguno";
        } else {
            for (int i = 0; i < delitos.size(); i++) {
                Delito d = delitos.get(i);
                info = info + "\n - " + d.getNombre() + " (" + d.getDiasConde() + " dias)";
            }
        }

        info = info + "\nAgravantes:";
        if (agravantes.size() == 0) {
            info = info + " Ninguno";
        } else {
            for (int i = 0; i < agravantes.size(); i++) {
                Agravante a = agravantes.get(i);
                info = info + "\n - " + a.getNomAgra() + " (" + a.getNivelSegu() + ", " + a.getDiasAdio() + " dias)";
            }
        }

        return info;
    }
}

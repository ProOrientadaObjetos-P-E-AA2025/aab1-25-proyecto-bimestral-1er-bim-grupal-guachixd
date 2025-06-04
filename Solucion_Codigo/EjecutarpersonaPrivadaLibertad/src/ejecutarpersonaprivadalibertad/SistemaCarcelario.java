package ejecutarpersonaprivadalibertad;

import java.io.*;
import java.util.ArrayList;

public class SistemaCarcelario implements Serializable {
    private ArrayList<personaPrivadaLibertad> personas;
    private final String archivo = "personas.data";

    public SistemaCarcelario() {
        personas = cargarDatos();
    }

    private ArrayList<personaPrivadaLibertad> cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<personaPrivadaLibertad>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(personas);
        } catch (IOException e) {
            System.out.println("Error al guardar archivo");
        }
    }

    public void agregarPersona(personaPrivadaLibertad persona) {
        personas.add(persona);
        guardarDatos();
    }

    public void mostrarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }
        for (int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i));
            System.out.println("---------------------------");
        }
    }

    public ArrayList<personaPrivadaLibertad> getListaPersonas() {
        return personas;
    }
}



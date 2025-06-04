package ejecutarpersonaprivadalibertad;

import java.util.List;

public class EstadisticasCarcel {

    private int total;
    private int hombres;
    private int mujeres;
    private int conDiscapacidad;
    private int sumaEdades;
    private double promedioEdad;
    private double porcentajeDiscapacidad;

    public EstadisticasCarcel(SistemaCarcelario sistema) {
        List<personaPrivadaLibertad> personas = sistema.getListaPersonas();

        total = 0;
        hombres = 0;
        mujeres = 0;
        conDiscapacidad = 0;
        sumaEdades = 0;
        promedioEdad = 0.0;
        porcentajeDiscapacidad = 0.0;

        if (personas == null || personas.size() == 0) {
            return;
        }

        for (int i = 0; i < personas.size(); i++) {
            personaPrivadaLibertad p = personas.get(i);
            total++;

            if (p.getSexo().equalsIgnoreCase("Masculino")) {
                hombres++;
            } else if (p.getSexo().equalsIgnoreCase("Femenino")) {
                mujeres++;
            }

            if (p.getDiscapacidad().equalsIgnoreCase("Si")) {
                conDiscapacidad++;
            }

            sumaEdades += p.getEdad();
        }

        promedioEdad = (double) sumaEdades / total;
        porcentajeDiscapacidad = ((double) conDiscapacidad * 100) / total;
    }

    public int getTotal() {
        return total;
    }

    public int getHombres() {
        return hombres;
    }

    public int getMujeres() {
        return mujeres;
    }

    public int getConDiscapacidad() {
        return conDiscapacidad;
    }

    public double getPromedioEdad() {
        return promedioEdad;
    }

    public double getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    public void mostrarEstadisticas() {
        if (total == 0) {
            System.out.println("No hay personas registradas");
            return;
        }

        System.out.println("--- Estadisticas basicas ---");
        System.out.println("Total personas: " + total);
        System.out.println("Hombres: " + hombres);
        System.out.println("Mujeres: " + mujeres);
        System.out.println("Con discapacidad: " + conDiscapacidad);
        System.out.println("Porcentaje con discapacidad: " + porcentajeDiscapacidad + "%");
        System.out.println("Edad promedio: " + promedioEdad);
    }
}

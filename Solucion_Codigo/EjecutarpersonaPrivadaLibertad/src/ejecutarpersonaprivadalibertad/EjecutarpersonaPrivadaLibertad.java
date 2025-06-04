package ejecutarpersonaprivadalibertad;

import java.util.Scanner;

public class EjecutarpersonaPrivadaLibertad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaCarcelario sistema = new SistemaCarcelario();

        int op;
        String nombre, cedula, discapacidad, nivelSegu, fechaIngreso, sexo;
        int edad, cantDeli, cantAgra, dias, diasAdio;
        String nomDeli, nomAgra;
        boolean bandera = true;

        System.out.println("Sistema penitenciario Loja-Ecuador");
        System.out.println("----------------------------------");
        System.out.println("Que deseas realizar ?");

        while (bandera) {
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar PPLS");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Salir");
            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        System.out.println("Ingrese el nombre:");
                        nombre = sc.nextLine();
                        System.out.println("Ingrese la cedula:");
                        cedula = sc.nextLine();
                        System.out.println("Ingrese el sexo (Masculino/Femenino):");
                        sexo = sc.nextLine();
                        System.out.println("Presenta alguna discapacidad? (Si/No):");
                        discapacidad = sc.nextLine();

                        while (true) {
                            try {
                                System.out.println("Ingrese la edad: ");
                                edad = Integer.parseInt(sc.nextLine());
                                if (edad < 18 || edad > 100) {
                                    System.out.println("Ingrese una edad valida!");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error dato invalido");
                            }
                        }

                        System.out.println("Ingrese nivel de seguridad (Bajo/Medio/Alto):");
                        nivelSegu = sc.nextLine();
                        System.out.println("Ingrese fecha de ingreso (formato: dd/mm/aa):");
                        fechaIngreso = sc.nextLine();

                        personaPrivadaLibertad persona = new personaPrivadaLibertad(nombre, cedula, sexo, discapacidad, edad, nivelSegu, fechaIngreso);

                        while (true) {
                            try {
                                System.out.println("Cuantos delitos desea agregar?");
                                cantDeli = Integer.parseInt(sc.nextLine());
                                if (cantDeli <= 0) {
                                    System.out.println("Los delitos no pueden ser un valor negativo o cero");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error, ingrese un numero valido");
                            }
                        }

                        for (int i = 0; i < cantDeli; i++) {
                            System.out.println("Ingrese el nombre del delito:");
                            nomDeli = sc.nextLine();

                            while (true) {
                                try {
                                    System.out.println("Dias de condena:");
                                    dias = Integer.parseInt(sc.nextLine());
                                    if (dias < 0) {
                                        System.out.println("Los dias no pueden ser menores a 0");
                                    } else {
                                        break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error, ingrese un numero valido");
                                }
                            }

                            persona.agregarDelito(new Delito(nomDeli, dias));
                        }

                        while (true) {
                            try {
                                System.out.println("Ingrese el numero de agravantes cometidos:");
                                cantAgra = Integer.parseInt(sc.nextLine());
                                if (cantAgra < 0) {
                                    System.out.println("El numero de agravantes no puede ser negativo");
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                System.out.println("Error, ingrese un numero valido");
                            }
                        }

                        for (int i = 0; i < cantAgra; i++) {
                            System.out.println("Nombre del agravante #" + (i + 1) + ":");
                            nomAgra = sc.nextLine();

                            System.out.println("Ojo. A.Leve(Reduccion visitas) AGrave/Muy Grave (Aumento condena)");
                            System.out.println("Ingrese el nivel del Agravnate (Leve/Grave/Muy Grave):");
                            nivelSegu = sc.nextLine();

                            diasAdio = 0;
                            if (nivelSegu.equalsIgnoreCase("Grave") || nivelSegu.equalsIgnoreCase("Muy Grave")) {
                                while (true) {
                                    try {
                                        System.out.println("Dias adicionales:");
                                        diasAdio = Integer.parseInt(sc.nextLine());
                                        if (diasAdio < 0) {
                                            System.out.println("Los dias adicionales no pueden ser menores a 0");
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error, ingrese un numero valido");
                                    }
                                }
                            }

                            persona.agregarAgravante(new Agravante(nomAgra, diasAdio, nivelSegu));
                        }

                        sistema.agregarPersona(persona);
                        System.out.println("Persona agregada con exito");
                        break;

                    case 2:
                        sistema.mostrarPersonas();
                        break;

                    case 3:
                      EstadisticasCarcel estadisticas = new EstadisticasCarcel(sistema);
                      estadisticas.mostrarEstadisticas();
                        break;

                    case 4:
                        bandera = false;
                        break;

                    default:
                        System.out.println("Error, Ingrese una opcion valida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error, ingrese un numero valido");
            }
        }
    }
}

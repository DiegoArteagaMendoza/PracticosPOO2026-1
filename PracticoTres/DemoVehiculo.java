package PracticoTres;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class DemoVehiculo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Colección para almacenar los vehículos
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        // Obtenemos el año actual para armar las fechas solicitadas
        int anioActual = LocalDate.now().getYear();
        LocalDate fechaWEC = LocalDate.of(anioActual, Month.MAY, 2);
        LocalDate fechaF1 = LocalDate.of(anioActual, Month.MAY, 15);
        LocalDate fechaIMSA = LocalDate.of(anioActual, Month.JUNE, 1);

        // EXTRAEMOS LAS CATEGORÍAS DIRECTAMENTE DEL ENUM
        Categoria[] categorias = Categoria.values();
        LocalDate[] fechas = {fechaWEC, fechaF1, fechaIMSA};

        System.out.println("--- Registro de Nuevos Modelos de Competición ---");

        // Bucle para solicitar la información iterando sobre el Enum
        for (int i = 0; i < categorias.length; i++) {
            System.out.println("\nIngrese los datos para el vehículo de " + categorias[i] + ":");

            System.out.print("Peso (kg): ");
            int peso = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea sobrante

            System.out.print("Color: ");
            String color = scanner.nextLine();

            System.out.print("Potencia Máxima (HP): ");
            int potencia = scanner.nextInt();

            // Instanciamos el vehículo pasándole el valor del ENUM (categorias[i])
            listaVehiculos.add(new Vehiculo(peso, color, potencia, fechas[i], categorias[i]));
        }

        // Sistema de Menú
        boolean salir = false;
        while (!salir) {
            System.out.println("\n======= MENÚ PRINCIPAL =======");
            System.out.println("1. ListarVehiculos()");
            System.out.println("2. RestanteCarrera()");
            System.out.println("3. ModificarMarca() a General Motors");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Lista de Vehículos ---");
                    ListarVehiculos(listaVehiculos);
                    break;
                case 2:
                    System.out.println("\n--- Tiempo Restante para las Carreras ---");
                    for (Vehiculo v : listaVehiculos) {
                        System.out.println("Categoría " + v.categoria + ": faltan " + v.RestanteCarrera() + " días.");
                    }
                    break;
                case 3:
                    // Se llama a la clase, no a la instancia, para modificar la marca
                    Vehiculo.ModificarMarca("General Motors");
                    System.out.println("\n[!] La marca ha sido actualizada a General Motors para toda la flota.");
                    break;
                case 4:
                    salir = true;
                    System.out.println("\nCerrando el sistema...");
                    break;
                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    // Método auxiliar para iterar y mostrar la colección
    public static void ListarVehiculos(ArrayList<Vehiculo> vehiculos) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println(v.toString());
        }
    }
}
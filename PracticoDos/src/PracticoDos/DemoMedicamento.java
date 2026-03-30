package PracticoDos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Scanner;

class Medicamento {
    private String nombre;
    private Tipo presentacion;
    private LocalDate fechaVencimiento;

    public Medicamento(String nom, Tipo p, LocalDate fechaVenc) {
        this.nombre = nom;
        this.presentacion = p;
        this.fechaVencimiento = fechaVenc;
    }

    public String getNombre() {return this.nombre;}
    public Tipo getPresentacion() {return this.presentacion;}
    public LocalDate getFechaVencimiento() {return this.fechaVencimiento;}
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public int getDiasDeValidez() {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), this.fechaVencimiento);
        return dias <= 0 ? 0 : (int) dias;

//        if (dias <= 0) {
//            return 0;
//        } else {
//            return (int) dias;
//        }

    }

    @Override
    public String toString() {
        // formateando la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = this.fechaVencimiento.format(formatter);
        String presentacionMinuscula = this.presentacion.name().toLowerCase();

        return this.nombre + ";" + presentacionMinuscula + ";" + fechaFormateada;
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;

        // Casteo seguro despues de validar clase
        Medicamento medicamento = (Medicamento) otro;
        return Objects.equals(nombre, medicamento.nombre)  && presentacion == medicamento.presentacion;
    }
}

public class DemoMedicamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Medicamento[] medicamentos = new Medicamento[3];

        System.out.println("--- INGRESO DE DATOS ---");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nMedicamento " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Presentación (COMPRIMIDO, CAPSULA, POLVO, GOTAS): ");
            Tipo presentacion = Tipo.valueOf(scanner.nextLine().toUpperCase());

            System.out.print("Fecha de Vencimiento (dd-MM-yyyy): ");
            LocalDate fecha = LocalDate.parse(scanner.nextLine(), formatter);

            medicamentos[i] = new Medicamento(nombre, presentacion, fecha);
        }

        System.out.println("\n========================================");

        System.out.println("--- COMPARACIÓN DE MEDICAMENTOS ---");
        System.out.println("¿Medicamento 1 es igual al 2?: " + medicamentos[0].equals(medicamentos[1]));
        System.out.println("¿Medicamento 1 es igual al 3?: " + medicamentos[0].equals(medicamentos[2]));
        System.out.println("¿Medicamento 2 es igual al 3?: " + medicamentos[1].equals(medicamentos[2]));

        System.out.println("\n--- LISTA DE MEDICAMENTOS ---");
        for (Medicamento m : medicamentos) {
            System.out.println(m.toString());
//            System.out.println(m.getPresentacion());
//            System.out.println(m.getDiasDeValidez());
        }

        Medicamento maxValidez = medicamentos[0];
        for (int i = 1; i < medicamentos.length; i++) {
            if (medicamentos[i].getDiasDeValidez() > maxValidez.getDiasDeValidez()) {
                System.out.println("nombre med nuevo " + i +": " + medicamentos[i].getNombre());
                System.out.println("nombre med viejo " + i +": " + maxValidez.getNombre());
                maxValidez = medicamentos[i];
            }
        }
        System.out.println("\n--- PRODUCTO CON MÁS DÍAS DE VALIDEZ ---");
        System.out.println(maxValidez.getNombre() + " (" + maxValidez.getDiasDeValidez() + " días restantes)");

        System.out.println("\n--- PRODUCTOS VENCIDOS ---");
        medicamentos[0].setFechaVencimiento(LocalDate.now().minusDays(10));

        System.out.println("Se forzó el vencimiento de: " + medicamentos[0].getNombre());
        System.out.println("Listado de vencidos actualmente:");

        boolean hayVencidos = false;
        for (Medicamento m : medicamentos) {
            if (m.getDiasDeValidez() == 0) {
                System.out.println("- " + m.getNombre());
                hayVencidos = true;
            }
        }

        if (!hayVencidos) {
            System.out.println("No hay productos vencidos.");
        }

        scanner.close();
    }
}
package PracticoUno;

import java.util.ArrayList;
import java.util.List;

// 1. Clase ParteUno.Mascota
class Mascota {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private String especie;
    private boolean atendida;

    public Mascota(String nombre, String especie) {
        this.nombre = nombre;
        this.especie = especie;
        this.atendida = false; // Estado inicial
    }

    public void recibirTratamiento() {
        this.atendida = true;
        System.out.println("Mascota " + this.nombre + " (" + this.especie + ") ha recibido su tratamiento. ¡Está feliz!");
    }

    public String getNombre() {
        return this.nombre;
    }

    public boolean isAtendida() {
        return this.atendida;
    }
}

// 2. Clase ParteUno.ClinicaVeterinaria
class ClinicaVeterinaria {
    private String nombreClinica;
    private List<Mascota> pacientes; // Lista que guardará objetos de tipo ParteUno.Mascota

    public ClinicaVeterinaria(String nombreClinica) {
        this.nombreClinica = nombreClinica;
        this.pacientes = new ArrayList<>();
    }

    public void registrarPaciente(Mascota mascota) {
        this.pacientes.add(mascota);
        System.out.println("Paciente '" + mascota.getNombre() + "' registrado en " + this.nombreClinica + ".");
    }

    public void realizarRondaMedica() {
        System.out.println("\n--- Iniciando ronda médica en " + this.nombreClinica + " ---");
        for (Mascota mascota : this.pacientes) {
            if (!mascota.isAtendida()) {
                mascota.recibirTratamiento();
            } else {
                System.out.println("ParteUno.Mascota " + mascota.getNombre() + " ya estaba atendido.");
            }
        }
    }
}

// 3. Clase principal para ejecutar el programa
public class Main {
    public static void main(String[] args) {
        // Instanciación de los objetos
        ClinicaVeterinaria miClinica = new ClinicaVeterinaria("Letirinaria");
        Mascota perro1 = new Mascota("Leti", "Perro");
        Mascota gato1 = new Mascota("Michi", "Gato");

        miClinica.registrarPaciente(perro1);
        miClinica.registrarPaciente(gato1);

        miClinica.realizarRondaMedica();
    }
}
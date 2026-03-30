package PracticoTres;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Vehiculo {
    private int peso;
    private String color;
    private int potenciaMaxima;
    private LocalDate fechaPrimeraCarrera;
    Categoria categoria;
    private static String marca = "Cadillac";

    public Vehiculo(int peso, String color, int potenciaMaxima, LocalDate fechaPrimeraCarrera, Categoria categoria) {
        this.peso = peso;
        this.color = color;
        this.potenciaMaxima = potenciaMaxima;
        this.fechaPrimeraCarrera = fechaPrimeraCarrera;
        this.categoria = categoria;
//        marca = "Cadillac";
    }

    public int RestanteCarrera() {
        long dias = ChronoUnit.DAYS.between(LocalDate.now(), this.fechaPrimeraCarrera);
        int restante = (int) dias;
        return restante;
    }

    public static void ModificarMarca(String nuevaMarca) {
        marca = nuevaMarca;
    }

    @Override
    public String toString() {
        return marca + "; " + this.categoria + "; " + this.fechaPrimeraCarrera + "; " + this.color + "; " + this.potenciaMaxima + "; " + this.peso;
    }
}

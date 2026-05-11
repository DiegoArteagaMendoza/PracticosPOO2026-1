package PracticoCuatro;

public class Usuario {
    private int edad;

    public void setEdad(int edad) throws MiPropiaException {
        if (edad < 0 || edad > 120) {
            throw new MiPropiaException("Edad fuera de rango [0, 120]");
        } else {
            this.edad = edad;
        }
    }

    public int getEdad() {
        return edad;
    }
}
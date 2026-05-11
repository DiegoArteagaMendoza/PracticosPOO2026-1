package PracticoCuatro;

public class Ejercicio2 {
   
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        try {
            System.out.println("Intentando asignar edad: 150...");
            usuario.setEdad(150); 
        } catch (MiPropiaException e) {
            System.out.println("Captura de excepción: " + e.getMessage());
        }

        try {
            System.out.println("\nIntentando asignar edad: 25...");
            usuario.setEdad(25);
            System.out.println("Edad asignada correctamente");
        } catch (MiPropiaException e) {
            System.out.println(e.getMessage());
        }
    }
    
}

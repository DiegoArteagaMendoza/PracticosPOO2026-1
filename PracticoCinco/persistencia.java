import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class persistencia {

    private static final String RUTA_ARCHIVO = "bitacora.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n--- GESTOR DE BITÁCORA ---");
            System.out.println("1. Agregar nuevo registro");
            System.out.println("2. Leer registros");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el mensaje para la bitácora: ");
                        String mensaje = scanner.nextLine();
                        escribirEnArchivo(mensaje);
                        break;
                    case 2:
                        leerArchivo();
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
            }
        }
        scanner.close();
    }

    /**
     * Escribe un mensaje en el archivo de texto.
     */
    private static void escribirEnArchivo(String mensaje) {
        // Obtenemos la fecha y hora actual para darle formato al log
        String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String linea = "[" + fechaHora + "] " + mensaje;

        // FileWriter con el parámetro 'true' indica que haremos un "append" (agregar al final)
        try (FileWriter fw = new FileWriter(RUTA_ARCHIVO, true);
            BufferedWriter bw = new BufferedWriter(fw)) {
            
            bw.write(linea);
            bw.newLine(); // Salto de línea dependiente del sistema operativo
            System.out.println("Registro guardado exitosamente.");
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee y muestra por consola todo el contenido del archivo.
     */
    private static void leerArchivo() {
        File archivo = new File(RUTA_ARCHIVO);
        
        if (!archivo.exists()) {
            System.out.println("La bitácora está vacía o el archivo aún no existe.");
            return;
        }

        System.out.println("\n--- CONTENIDO DE LA BITÁCORA ---");
        
        try (FileReader fr = new FileReader(archivo);
             BufferedReader br = new BufferedReader(fr)) {
            
            String lineaLeida;
            // readLine() devuelve null cuando alcanza el final del archivo
            while ((lineaLeida = br.readLine()) != null) {
                System.out.println(lineaLeida);
            }
            System.out.println("--------------------------------");
            
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
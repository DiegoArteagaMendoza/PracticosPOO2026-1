import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResolucionEjerciciosStreams {

    // Clase auxiliar para el Ejercicio 3
    static class Empleado {
        private String nombre;
        private double salario;

        public Empleado(String nombre, double salario) {
            this.nombre = nombre;
            this.salario = salario;
        }

        public String getNombre() { return nombre; }
        public double getSalario() { return salario; }

        @Override
        public String toString() {
            return nombre + " ($" + salario + ")";
        }
    }

    public static void main(String[] args) {
        
        System.out.println("--- EJERCICIO 1: Filtrado y Suma ---");
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        int sumaPares = numeros.stream()
                .filter(n -> n % 2 == 0)            // Operación intermedia: filtra pares
                .mapToInt(Integer::intValue)        // Operación intermedia: convierte a IntStream
                .sum();                             // Operación terminal: suma total
                
        System.out.println("Lista original: " + numeros);
        System.out.println("Suma de los números pares: " + sumaPares);
        System.out.println();


        System.out.println("--- EJERCICIO 2: Transformación y Ordenamiento ---");
        List<String> nombres = Arrays.asList("carlos", "ana", "pedro", "beatriz");
        
        List<String> nombresProcesados = nombres.stream()
                .map(String::toUpperCase)           // Operación intermedia: a mayúsculas
                .sorted()                           // Operación intermedia: orden alfabético
                .collect(Collectors.toList());      // Operación terminal: recolectar en Lista
                
        System.out.println("Nombres originales: " + nombres);
        System.out.println("Nombres procesados: " + nombresProcesados);
        System.out.println();


        System.out.println("--- EJERCICIO 3: Búsqueda del Máximo ---");
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Juan", 2500.50),
                new Empleado("María", 3800.00),
                new Empleado("Luis", 1900.00),
                new Empleado("Sofía", 4200.75)
        );

        Optional<Empleado> empleadoMejorPagado = empleados.stream()
                // Operación terminal: busca el máximo comparando por el atributo salario
                .max(Comparator.comparingDouble(Empleado::getSalario));

        // Verificamos si existe el empleado y lo imprimimos
        empleadoMejorPagado.ifPresent(empleado -> 
            System.out.println("El empleado con mayor salario es: " + empleado)
        );
    }
}
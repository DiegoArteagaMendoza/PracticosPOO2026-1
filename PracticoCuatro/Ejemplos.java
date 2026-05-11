package PracticoCuatro;
import java.util.Scanner;

public class Ejemplos {
    
    static Scanner sc = new Scanner(System.in);

    // ejemplo 1: Error de división por 0, aplicando Excepcioón del tipo Exception y del tipo ArithmeticException

    public static void ejemploUnoException() {
        System.out.print("Ingrese un numero: ");
        int a = sc.nextInt();
        System.out.println("Dividiendo por 0 " + a + "/0");
        
        try {
            int ans = a / 0;
            System.out.println("Resultado división: " + ans);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void ejemploUnoArithmeticException() {
        System.out.print("Ingrese un numero: ");
        int a = sc.nextInt();
        System.out.println("Dividiendo por 0 " + a + "/0");
        
        try {
            int ans = a / 0;
            System.out.println("Resultado división: " + ans);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Ejemplo 2: Error de lectura de string convertido a numero
    public static void ejemploUnoString(String tipo) {
        System.out.print("Ingrese " + tipo + ": ");
        String palabra = sc.next();
        int palabraNum;
        System.out.println("Convirtiendo");
        try {
            palabraNum = Integer.parseInt(palabra);
            System.out.println(palabraNum);
        } catch (NumberFormatException e) {
            System.out.println("\n Error: " + e.getMessage());
        }
    }

    public static void ejemploNuevaExcepcion() {
        try {
            System.out.print("Ingrese un numero mayor o igual a 10: ");
            int num = sc.nextInt();

            if (num < 10) {
                // Lanzamos la excepción manualmente si no cumple la regla de 
                throw new NumberFormatException("El numero ingresado (" + num + ") no es mayor o igual a 10");
            }

            System.out.println("Excelente, sabes leer.");

        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            
            ejemploNuevaExcepcion();
            
        } catch (Exception e) {
            System.out.println("Error: Debes ingresar un número válido.");
            sc.nextLine();
            ejemploNuevaExcepcion();
        }
    }

    public static void ejemploNuevaExcepcionDos(int saldo) {
        try {
            System.out.println("\n--- Operación de Retiro ---");
            System.out.println("Su saldo es de: " + saldo);
            System.out.print("Ingrese el monto a retirar: ");
            int retiro = sc.nextInt();

            if (retiro == 0) {
                throw new Exception("El monto a retirar no puede ser cero (0).");
            }
            if (retiro < 0) {
                throw new IllegalArgumentException("No puede retirar montos negativos.");
            }
            if (retiro > saldo) {
                throw new IllegalArgumentException("Monto a retirar es superior al saldo disponible.");
            }

            saldo -= retiro;
            System.out.println("Retiro exitoso: " + retiro);
            System.out.println("Nuevo saldo: " + saldo);

        } catch (IllegalArgumentException e) {
            System.out.println("Error de validación: " + e.getMessage());
            ejemploNuevaExcepcionDos(saldo);

        } catch (Exception e) {
            System.out.println("Error general: " + e.getMessage());
            sc.nextLine();
            ejemploNuevaExcepcionDos(saldo); 
        }
    }

    public static void main(String[] args) throws Exception {
        
        // System.out.println("EJECUTANDO EL EJEMPLO 1 Exception");
        // ejemploUnoException();
        // System.out.println("======================");

        // System.out.println("EJECUTANDO EL EJEMPLO 1 ArithmeticException");
        // ejemploUnoArithmeticException();
        // System.out.println("======================");

        // System.out.println("EJECUTANDO EL EJEMPLO 2 CON PALABRA");
        // ejemploUnoString("palabra");
        // System.out.println("======================");

        // System.out.println("EJECUTANDO EL EJEMPLO 2 CON NUMERO");
        // ejemploUnoString("numero");
        // System.out.println("======================");

        // System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 1 (TODO CORRECTO)");
        // ejemploNuevaExcepcion();
        // System.out.println("======================");

        // System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 1 (TODO INCORRECTO)");
        // ejemploNuevaExcepcion();
        // System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 2 (TODO CORRECTO)");
        ejemploNuevaExcepcionDos(100000);
        System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 2 (TODO INCORRECTO)");
        ejemploNuevaExcepcionDos(100000);
        System.out.println("======================");
    }

}

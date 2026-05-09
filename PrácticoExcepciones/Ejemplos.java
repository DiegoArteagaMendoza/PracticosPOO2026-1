package PrácticoExcepciones;
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

    // Ejemplo 3: Creando excepciones
    public static void ejemploNuevaExcepcion() {
        System.out.print("Ingrese un numero mayor o igual a 10: ");
        int num = sc.nextInt();

        if (num >= 10) {
            System.out.println("Exelente sabes leer");
        } else {
            throw new NumberFormatException("El numero ingresado no es mayor o igual a 10");
        }
    }

    public static void ejemploNuevaExcepcionDos() throws Exception {
        int saldo = 100000;
        System.out.println("Su saldo es de: " + saldo);
        System.out.print("Ingrese el monto a retirar: ");
        int retiro = sc.nextInt();

        if (retiro <= saldo) {
            saldo -=retiro;
            System.out.println("Saldo retirado: " + retiro + "\nNuevo saldo: " + saldo);
        }
        if (retiro > saldo) {
            throw new IllegalArgumentException("Monto a retirar es superior al saldo disponible.");
        }
        if (retiro == 0) {
            throw new Exception("El saldo a retirar no puede se cero (0)");
        }
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println("EJECUTANDO EL EJEMPLO 1 Exception");
        ejemploUnoException();
        System.out.println("======================");

        System.out.println("EJECUTANDO EL EJEMPLO 1 ArithmeticException");
        ejemploUnoArithmeticException();
        System.out.println("======================");

        System.out.println("EJECUTANDO EL EJEMPLO 2 CON PALABRA");
        ejemploUnoString("palabra");
        System.out.println("======================");

        System.out.println("EJECUTANDO EL EJEMPLO 2 CON NUMERO");
        ejemploUnoString("numero");
        System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 1 (TODO CORRECTO)");
        ejemploNuevaExcepcion();
        System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 1 (TODO INCORRECTO)");
        ejemploNuevaExcepcion();
        System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 2 (TODO CORRECTO)");
        ejemploNuevaExcepcionDos();
        System.out.println("======================");

        System.out.println("EJECUTNADO EL EJEMPLO 3 DE NUEVA EXCEPCION CASO 2 (TODO INCORRECTO)");
        ejemploNuevaExcepcionDos();
        System.out.println("======================");
    }

}

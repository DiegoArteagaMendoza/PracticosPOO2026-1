package PracticoCuatro;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el numerador: ");
            int num = sc.nextInt();
            System.out.print("Ingrese el denominador: ");
            int den = sc.nextInt();
            System.out.println("Resultado: " + num/den);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

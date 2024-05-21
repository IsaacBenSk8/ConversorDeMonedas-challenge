package com.aluracursos.challenge.models;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String currentCurrency = "";
        String expectedCurrency = "";
        ConversorApi conversor = new ConversorApi();

        int cantidad = 0;
        int opcion = 1;
        String menu = """
                    ========================================
                    Bienvenido al Conversor de Monedas! :)
                    ========================================
                    Elija una opción para continuar:
                    ---
                    1) Dolar -> Peso argentino
                    2) Peso argentino -> Dolar
                    3) Dolar -> Real brasileño
                    4) Real brasileño -> Dolar
                    5) Dolar -> Peso colombiano
                    6) Peso colombiano -> Dolar
                    7) Salir
                    Elija una opción válida:
                    ========================================
                    """;

        while (true) {
            try {
                System.out.println(menu);
                opcion = teclado.nextInt();

                if (opcion == 7) {
                    System.out.println("Finalizando aplicación.");
                    break;
                }

                switch (opcion){
                    case 1:
                        currentCurrency = "USD";
                        expectedCurrency = "ARS";
                        break;
                    case 2:
                        currentCurrency = "ARS";
                        expectedCurrency = "USD";
                        break;
                    case 3:
                        currentCurrency = "USD";
                        expectedCurrency = "BRL";
                        break;
                    case 4:
                        currentCurrency = "BRL";
                        expectedCurrency = "USD";
                        break;
                    case 5:
                        currentCurrency = "USD";
                        expectedCurrency = "COP";
                        break;
                    case 6:
                        currentCurrency = "COP";
                        expectedCurrency = "USD";
                        break;
                }
                System.out.println("Ahora ingrese la cantidad a convertir: ");
                cantidad = teclado.nextInt();

                Moneda newValue = conversor.conversor(currentCurrency, expectedCurrency, cantidad);
                System.out.println("""
                    ======================
                    Resultados
                    ======================
                    """);
                System.out.println("El valor de " + cantidad + " [" + currentCurrency + "] equivale a " + newValue.conversion_result() + " [" + expectedCurrency + "].");
            } catch (Exception e) {
                System.out.println("Ocurrió un error al ingresar los datos, intente iniciar la aplicación de nuevo.");
                break;
            }
        }
    }
}

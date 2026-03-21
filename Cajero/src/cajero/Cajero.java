package cajero;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Cajero {
    // Saldo inicial del cajero en billetes
    static Map<Integer, Integer> cajero = new TreeMap<>((a, b) -> b - a);

    static {
        cajero.put(100, 220);
        cajero.put(50, 150);  
        cajero.put(20, 300);  
    }

    public static void mostrarSaldo() {
        System.out.println("\n--- Saldo del cajero ---");
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : cajero.entrySet()) {
            int billete = entry.getKey();
            int cantidad = entry.getValue();
            System.out.println("Billetes de " + billete + ": " + cantidad);
            total += billete * cantidad;
        }
        System.out.println("Saldo total en dinero: " + total);
        System.out.println("-------------------------");
    }

    public static void retirarBilletes(int billete, int cantidad) {
        int disponibles = cajero.get(billete);

        if (cantidad <= disponibles) {
            cajero.put(billete, disponibles - cantidad);
            System.out.println("Se retiraron " + cantidad + " del billete de " + billete);
        } else {
            System.out.println("No hay suficientes billetes de " + billete + ". Disponibles: " + disponibles);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            mostrarSaldo();
            System.out.println("Opciones: ");
            System.out.println("1. Retirar billetes");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 0) {
                continuar = false;
                System.out.println("Gracias por usar el cajero.");
            } else if (opcion == 1) {
                System.out.print("Ingrese el tipo de billete (100, 50, 20): ");
                int billete = sc.nextInt();

                // Verificación de billete válido
                if (!cajero.containsKey(billete)) {
                    System.out.println("Lo siento, no tenemos billetes de " + billete + " soles disponibles.");
                    continue; // vuelve al menú sin pedir cantidad
                }

                System.out.print("Ingrese la cantidad de billetes que desea retirar: ");
                int cantidad = sc.nextInt();
                retirarBilletes(billete, cantidad);
            } else {
                System.out.println("Opcion invalida.");
            }
        }

        sc.close();
    }
}


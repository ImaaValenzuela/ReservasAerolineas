package interfaz;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vuelos[][];

        System.out.println("¡Bienvenido a la compra de boletos!");

        System.out.println("Ingrese la cantidad de destinos que desea tener: ");
        int destinos = sc.nextInt();
        vuelos = new int[3][destinos];

        String nombresDestinos[] = new String[destinos];
        int longitudArreglosDestinos = nombresDestinos.length;

        for (int i = 0; i < longitudArreglosDestinos; i++) {
            System.out.println("Ingrese el nombre del destino #" + (i + 1) + ": ");
            nombresDestinos[i] = sc.next();
            sc.nextLine();
        }

        System.out.println("Ingrese la cantidad de asientos disponibles para cada vuelo:");

        for (int i = 0; i < longitudArreglosDestinos; i++) {
            for (int j = 0; j < 3; j++) {
                String horario = obtenerNombreHorario(j);
                System.out.println("Vuelo " + horario + " a " + nombresDestinos[i] + ": ");
                vuelos[j][i] = sc.nextInt();
            }
        }

        String finalizar = "";

        while (!finalizar.equalsIgnoreCase("finish")) {
            System.out.println("Los destinos disponibles son:");

            for (int i = 0; i < longitudArreglosDestinos; i++) {
                System.out.println((i + 1) + ". " + nombresDestinos[i]);
            }

            int indiceElegido;
            do {
                System.out.println("Ingrese el número del destino al que desea dirigirse: ");
                indiceElegido = sc.nextInt();

                if (indiceElegido <= 0 || indiceElegido > destinos) {
                    System.out.println("Número de destino inválido. Por favor, ingrese un número válido.");
                }
            } while (indiceElegido <= 0 || indiceElegido > destinos);

            int indiceReal = indiceElegido - 1;
            System.out.println("Destino seleccionado: " + nombresDestinos[indiceReal]);

            for (int j = 0; j < 3; j++) {
                String horario = obtenerNombreHorario(j);
                System.out.println((j + 1) + ". " + horario + ": " + vuelos[j][indiceReal] + " asientos disponibles");
            }

            int horarioElegido;
            do {
                System.out.println("Ingrese el número del horario en el que desea viajar: ");
                horarioElegido = sc.nextInt();

                if (horarioElegido <= 0 || horarioElegido > 3) {
                    System.out.println("Número de horario inválido. Por favor, ingrese un número de horario válido.");
                }
            } while (horarioElegido <= 0 || horarioElegido > 3);

            int horarioReal = horarioElegido - 1;
            System.out.println("Vuelo seleccionado: " + obtenerNombreHorario(horarioReal) + " - Asientos disponibles: " + vuelos[horarioReal][indiceReal]);

            int cantidadAsientos;
            do {
                System.out.println("Ingrese la cantidad de asientos que desea comprar: ");
                cantidadAsientos = sc.nextInt();

                if (cantidadAsientos <= 0 || cantidadAsientos > vuelos[horarioReal][indiceReal]) {
                    System.out.println("Cantidad de asientos inválida. Por favor, ingrese una cantidad válida.");
                }
            } while (cantidadAsientos <= 0 || cantidadAsientos > vuelos[horarioReal][indiceReal]);

            System.out.println("¡Compra exitosa! Disfrute su vuelo.");
            vuelos[horarioReal][indiceReal] -= cantidadAsientos; // Actualizar la cantidad de asientos disponibles

            System.out.println("Ingrese 'finish' para finalizar el programa. Si desea continuar comprando, ingrese cualquier otro caracter.");
            finalizar = sc.next();
        }

        System.out.println("¡Gracias por utilizar nuestro servicio de compra de boletos! Hasta luego.");

        sc.close();
    }

    private static String obtenerNombreHorario(int indice) {
        switch (indice) {
            case 0:
                return "Mañana";
            case 1:
                return "Mediodía";
            case 2:
                return "Noche";
            default:
                return "Desconocido";
        }
    }
}
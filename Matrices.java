package JavaGitUnidad3;

import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int filas = 2;
        int columnas = 3;

        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[filas][columnas];

        completarMatrices(matrizA, "A", leer);
        completarMatrices(matrizB, "B", leer);

        int[][] suma = sumaMatriz(matrizA, matrizB);
        int[][] resta = restaMatriz(matrizA, matrizB);
        int[][] multiplicacion = multiplicacionPosiciones(matrizA, matrizB);

        mostrarResultados(suma, resta, multiplicacion);

        leer.close(); 
    }

    public static void completarMatrices(int[][] matriz, String nombre, Scanner leer) {
        System.out.println("Escriba los datos para la Matriz " + nombre + ":");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                while (true) {
                    System.out.print("Posición [" + i + "][" + j + "]: ");
                    if (leer.hasNextInt()) {
                        matriz[i][j] = leer.nextInt();
                        break;
                    } else {
                        System.out.println("¡Error! Ingrese un número entero.");
                        leer.next();
                    }
                }
            }
        }
    }

    public static int[][] sumaMatriz(int[][] a, int[][] b) {
        int[][] resultado = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                resultado[i][j] = a[i][j] + b[i][j];
            }
        }
        return resultado;
    }

    public static int[][] restaMatriz(int[][] a, int[][] b) {
        int[][] resultado = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                resultado[i][j] = a[i][j] - b[i][j];
            }
        }
        return resultado;
    }

    public static int[][] multiplicacionPosiciones(int[][] a, int[][] b) {
        int[][] resultado = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                resultado[i][j] = a[i][j] * b[i][j];
            }
        }
        return resultado;
    }

    public static void mostrarResultados(int[][] s, int[][] r, int[][] m) {
        System.out.println("\n--- RESULTADOS FINALES ---");

        System.out.println("Suma (A + B):");
        for (int[] fila : s) {
            for (int valor : fila) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();
        }

        System.out.println("\nResta (A - B):");
        for (int[] fila : r) {
            for (int valor : fila) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();
        }

        System.out.println("\nMultiplicación (Posición x Posición):");
        for (int[] fila : m) {
            for (int valor : fila) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();
        }
    }
}
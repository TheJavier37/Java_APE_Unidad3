package JavaGitUnidad3;

import java.util.Scanner;

public class Matrices {

    public static void main(String[] args) {
        Scanner leerMatriz = new Scanner(System.in);
        
        int filas = 2;
        int columnas = 3;

        int[][] matrizA = new int[filas][columnas];
        int[][] matrizB = new int[filas][columnas];

        completarMatrices(matrizA, "A", leerMatriz);
        completarMatrices(matrizB, "B", leerMatriz);

        int[][] suma = sumaMatriz(matrizA, matrizB);
        int[][] resta = restaMatriz(matrizA, matrizB);
        
        int[][] multiplicacion = multiplicacionMatriz(matrizA, matrizB);

        mostrarResultados(suma, resta, multiplicacion);

        leerMatriz.close();
    }

public static void completarMatrices(int[][] matriz, String nombreMatriz, Scanner leer) {
    System.out.println("Escriba los datos para la Matriz " + nombreMatriz + ":");
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[0].length; j++) {
            
            while (true) {
                System.out.print("Posición [" + i + "][" + j + "]: ");
                if (leer.hasNextInt()) {
                    matriz[i][j] = leer.nextInt();
                    break;
                } else {
                    System.out.println("¡Error! Debe ingresar un número entero.");
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
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                res[i][j] = a[i][j] - b[i][j];
            }
        }
        return res;
    }

    public static int[][] multiplicacionMatriz(int[][] a, int[][] b) {
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
            
                res[i][j] = a[i][j] * b[i][j]; 
            }
        }
        return res;
    }

    public static void mostrarResultados(int[][] suma, int[][] resta, int[][] multiplicacion) {
        System.out.println("\n--- RESULTADOS FINALES (2x3) ---");
        
        System.out.println("Suma (A + B):");
        imprimirOrdenadamente(suma);
        
        System.out.println("\nResta (A - B):");
        imprimirOrdenadamente(resta);
        
        System.out.println("\nMultiplicación (A Posiciones x B Posiciones):");
        imprimirOrdenadamente(multiplicacion);
    }

    private static void imprimirOrdenadamente(int[][] m) {
        for (int[] fila : m) {
            for (int valor : fila) {
                System.out.print("[" + valor + "] ");
            }
            System.out.println();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg3_julio_y_linsy;

import java.util.Scanner;

/**
 *
 * @author 29164
 */
public class Tarea3_Julio_y_Linsy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner balerion = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--Menu bonito de Julio y Linsy--(☞ﾟヮﾟ)☞");
            System.out.println("1. Veamos si podemos formar la palabra");
            System.out.println("2. Numero Primos");
            System.out.println("3. Ordenar alfabéticamente");
            System.out.println("4. Codificar cadenas");
            System.out.println("5. Jugando con arreglos");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = balerion.nextInt();
            balerion.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("--A seleccionado: Veamos si podemos formar la palabra--");
                    System.out.print("Ingrese la primera cadena: ");
                    String cadena1 = balerion.nextLine();

                    System.out.print("Ingrese la segunda cadena: ");
                    String cadena2 = balerion.nextLine();
                    String cadenaMasLarga = obtenerCadenaMasLarga(cadena1, cadena2);

                    if (verificarCadena(cadenaMasLarga, obtenerCadenaMasCorta(cadena1, cadena2))) {
                        System.out.println("Sí se puede armar " + obtenerCadenaMasCorta(cadena1, cadena2));
                    } else {
                        System.out.println("No se puede armar " + obtenerCadenaMasCorta(cadena1, cadena2));
                    }
                    break;

                case 2:
                    System.out.println("--A seleccionado: Numero Primos--");
                    System.out.print("Ingrese una cadena de números y letras: ");
                    String input = balerion.nextLine();
                    String resultado = ordenarCadena(input);
                    System.out.println("Cadena ordenada: " + resultado);
                    break;

                case 3:
                    System.out.println("--A seleccionado: Ordenar alfabéticamente--");
                    System.out.print("Ingrese una cadena: ");
                    String cadena = balerion.nextLine();
                    String result = ordenarYContarNumeros(cadena);

                    System.out.println("Cadena ordenada: " + result);
                    System.out.println("Cantidad de números: " + contarNumeros(cadena));
                    break;

                case 4:
                    System.out.println("--A seleccionado: Codificar cadenas --");
                    System.out.print("Introduce una cadena:");
                    String cadenita = balerion.nextLine();
                    System.out.print("Cadena codificada: " + codificarCadena(cadenita));
                    break;

                case 5:
                    System.out.println("--A seleccionado: Jugando con arreglos--");
                    int[] array = new int[10];
                    llenarArreglo(array);
                    imprimirArreglo(array);
                    break;

                case 6:
                default:
                    running = false;
                    System.out.println("Byee (´▽`ʃ♡ƪ)");
                    break;
            }
        }
    }

    public static String obtenerCadenaMasLarga(String cadena1, String cadena2) {
        if (cadena1.length() >= cadena2.length()) {
            return cadena1;
        } else {
            return cadena2;
        }
    }//case 1

    public static String obtenerCadenaMasCorta(String cadena1, String cadena2) {
        if (cadena1.length() < cadena2.length()) {
            return cadena1;
        } else {
            return cadena2;
        }
    }//case 1

    public static boolean verificarCadena(String cadenaLarga, String cadenaCorta) {
        char[] caracteresCorta = cadenaCorta.toCharArray();
        for (int i = 0; i < caracteresCorta.length; i++) {
            char c = caracteresCorta[i];
            if (cadenaLarga.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }//case 2

    public static String ordenarCadena(String cadena) {
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length - 1; i++) {
            for (int j = 0; j < caracteres.length - 1 - i; j++) {
                if (!esNumero(caracteres[j]) && esNumero(caracteres[j + 1])) {
                    char temp = caracteres[j];
                    caracteres[j] = caracteres[j + 1];
                    caracteres[j + 1] = temp;
                }
            }
        }

        return new String(caracteres);
    }//case 2

    public static boolean esNumero(char c) {
        return c >= '0' && c <= '9';
    }//case 2

    public static String ordenarYContarNumeros(String cadena) {
        cadena = cadena.toLowerCase();
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length - 1; i++) {
            for (int j = 0; j < caracteres.length - 1 - i; j++) {
                if (caracteres[j] > caracteres[j + 1]) {
                    char temp = caracteres[j];
                    caracteres[j] = caracteres[j + 1];
                    caracteres[j + 1] = temp;
                }
            }
        }
        String resultadoSinNumeros = "";
        for (int k = 0; k < caracteres.length; k++) {
            char c = caracteres[k];
            if (c >= 'a' && c <= 'z') {
                resultadoSinNumeros += c;
            }
        }
        return resultadoSinNumeros;
    }//case 3

    public static int contarNumeros(String cadena) {
        int cantidadNumeros = 0;
        char[] caracteres = cadena.toCharArray();
        for (int i = 0; i < caracteres.length; i++) {
            char c = caracteres[i];
            if (c >= '0' && c <= '9') {
                cantidadNumeros++;
            }
        }
        return cantidadNumeros;
    }//case 3

    public static String codificarCadena(String cadena) {
        char[] caracteres = cadena.toCharArray();
        String cadenaCodificada = "";

        for (int i = 0; i < caracteres.length; i++) {
            char cad = caracteres[i];

            if (cad >= 'a' && cad <= 'z') {
                int numero = cad - 96;
                cadenaCodificada += numero + "-";
            } else if (cad >= 'A' && cad <= 'Z') {
                int numero = cad - 64;
                cadenaCodificada += numero + "-";
            } else if (cad >= '0' && cad <= '9') {
                char letra = (char) (cad - '0' + 96);
                cadenaCodificada += Character.toUpperCase(letra) + "-";
            } else if (cad == ' ') {
                cadenaCodificada += " ";
            }
        }

        return cadenaCodificada;
    }//case 4

    public static void llenarArreglo(int[] array) {
        Scanner puchamon = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Introduce un número para la posición " + (i + 1) + ":");
            array[i] = puchamon.nextInt();
        }
    }//case 5

    public static void imprimirArreglo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Posición " + (i + 1) + ": " + array[i]);
        }
    }//case 5

}

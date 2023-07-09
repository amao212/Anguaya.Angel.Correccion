package AAUtility;

import java.util.Scanner;

public class AAUtilitario {
    static Scanner sc = new Scanner(System.in);
    /**
     * limpiar la consola
     */
     public final static void aaClear(){
        try {
            String operatingSystem = System.getProperty("os.name");     //Check the current operating system
              
            if(operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Verifica que se ingrese un número.
     * @param mensaje, mensaje que se muestra en consola.
     * @return numero si este es valido.
     */
    public static int aaGetNumeroPositivo(String mensaje) {
         int numero = 0;
        boolean numeroValido = false;

        System.out.print(mensaje);
        String entrada = sc.nextLine();
        while (!numeroValido) {
            try {
                numero = Integer.parseInt(entrada);
                if (numero == 0 || numero < 5 ) {
                    numeroValido = true;
                } else {
                    System.out.print("El número esta fuera de rango (seleccione otro numero): ");
                   
                    entrada = sc.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.print("El valor ingresado no es un número (ingrese un numero): ");
                
                entrada = sc.nextLine();
            }
        }

        return numero;

    }
}

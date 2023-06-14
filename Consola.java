import java.util.Scanner;

/* Esta clase contendrá la impresión en pantalla y la captura de ingreso por teclado */

public class Consola {

    // Métodos para imprimir
    public static void imprimir(String var) {
        System.out.println(var);
    }

    public static void imprimir(int var) {
        System.out.println(var);
    }

    public static void imprimir(double var) {
        System.out.println(var);
    }

    // Métodos para capturar por teclado
    public static String leertxt() {
        Scanner miTeclado = new Scanner(System.in);
        String txt = miTeclado.nextLine();
        return txt;
    }

    public static int leernum() {
        Scanner miTeclado = new Scanner(System.in);
        int num = miTeclado.nextInt();
        miTeclado.nextLine();
        return num;
    }

    public static double leerdoub() {
        Scanner miTeclado = new Scanner(System.in);
        double doub = miTeclado.nextDouble();
        miTeclado.nextLine();
        return doub;
    }
}

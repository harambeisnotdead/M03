import java.util.Scanner;

class Simulacion {
    public static String inputStr(String texto) {
        Scanner sc =  new Scanner(System.in);
        System.out.print(texto);
        return sc.nextLine();
    }

    public static int inputInt(String texto) {
        return Integer.parseInt(inputStr(texto));
    }

    public static void main(String[] args) {
        System.out.println("---------Simulador granja---------");
        Granja granja = new Granja(
            inputStr("[+] Tipo de granja (bovinos/equinos): "),
            inputInt("[+] Numero de animales obreros: "),
            inputInt("[+] Numero de animales crianza: "),
            inputInt("[+] Cantidad comida inicial: ")
        );
        int turnos = inputInt("[+] Numero de turnos a simular: ");

        for (int i=0; i<turnos; i++) {
            System.out.format("-------------Turno %s-------------\n", i);
            if (i%3==0) granja.recolectar();
            if (!granja.comer()) break;
        }
    }
}

import java.util.Random;
import java.util.Scanner;

public class REDBALANCE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        
        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println(" ___  ____ ___    ___   ____ _    ____ _  _ ____ ____ ");
        System.out.println(" |__] |___ |  \\   |__]  |__| |    |__| |\\ | |    |___ ");
        System.out.println(" |  \\ |___ |__/   |__]  |  | |___ |  | | \\| |___ |___ ");
        System.out.println("=======================================================");
        System.out.println("=======================================================");
        System.out.println("PRESIONA ENTER PARA INICIAR");
        scanner.nextLine();
        clearScreen();

        System.out.println("Cuatro cifras pendientes, cero billetes en el bolsillo y ni una sola puerta más que tocar");
        System.out.println("Tu única salida es el hipódromo: multiplicas tus últimas monedas en la pista o al amanecer vendrán a cobrarte");
        System.out.println(" ");
        System.out.println("Presiona ENTER para continuar");
        scanner.nextLine();
        clearScreen();

        
        System.out.println("                           REGLAS                               ");
        System.out.println("1. Al final de cada apuesta vendran a cobrarte parte de la deuda");
        System.out.println();
        System.out.println("2. Esta parte puede variar entre $50 - $200");
        System.out.println();
        System.out.println("3. Si no logras pagar a tiempo perderas de inmediato");
        System.out.println();
        System.out.println("4. Ten en cuenta que lo apostado se restara a tu saldo restante");
        System.out.println("Presiona ENTER para continuar");
        scanner.nextLine();
        clearScreen();

        double saldo = 1000.0;
        double deuda = 5000.0;
        double acumulado = 0.0;
        int selecciondecaballo = 0;

        do {
            while (deuda > 0) {
                System.out.println("===============================================");
                System.out.println("Tu saldo es de: " + saldo + "   =   Tu deuda es: " + deuda);
                System.out.println("===============================================");
                System.out.println("    Bienvenido a la carrera de caballos  ");
                System.out.println("         Selecciona tu caballo           ");
                System.out.println(" 1.Relampago  2.Pegazo  3.Potro  4.Fenix ");
                System.out.println("===============================================");

                
                do {
                    if (scanner.hasNextInt()) {
                        selecciondecaballo = scanner.nextInt();
                        if (selecciondecaballo < 1 || selecciondecaballo > 4) {
                            System.out.println("Opcion no valida, ingresa un numero valido (1-4):");
                        }
                    } else {
                        System.out.println("Opcion no valida, ingresa un numero valido (1-4):");
                        scanner.next(); 
                        selecciondecaballo = 0;
                    }
                } while (selecciondecaballo < 1 || selecciondecaballo > 4);

                System.out.println("Tu saldo es de: " + saldo);
                System.out.print("Ingresa tu apuesta inicial: ");
                double apuesta = scanner.nextDouble();
                System.out.println("Tu apuesta es de: " + apuesta);

                double saldorestante = saldo - apuesta;
                System.out.println("Tu saldo restante es: " + saldorestante);
                
                
                scanner.nextLine();
                clearScreen();

                if (apuesta > saldo) {
                    System.out.println("Lo sentimos no cuentas con ese saldo");
                    apuesta = 0;
                } else {
                    int caballoganador = random.nextInt(4) + 1; 

                    if (caballoganador == selecciondecaballo) {
                        saldo = saldo + (apuesta * 1.50);
                        System.out.println(" =================================== ");
                        System.out.println(" = Tu caballo ha ganado la carrera = ");
                        System.out.println(" =================================== ");
                        System.out.println("  Tu nuevo saldo es de: " + saldo);
                        System.out.println("=====================================");
                    } else {
                        saldo = saldo - apuesta;
                        System.out.println(" ================================== ");
                        System.out.println(" = Tu caballo perdio la apuesta   = ");
                        System.out.println(" ================================== ");
                        System.out.println("  Tu nuevo saldo es de: " + saldo);
                        System.out.println("=================================== ");
                    }
                }

                System.out.println("Presiona ENTER para continuar");
                scanner.nextLine();
                clearScreen();

                acumulado += saldo;
                int pago = random.nextInt(151) + 50; 
                System.out.println("El sol ya salió y tus " + pago + " de deuda siguen sin aparecer.");
                System.out.println("                      Pagaras tu deuda?                     ");
                System.out.println("                            V/F                             ");
                
                String respuestaPago = scanner.nextLine().trim().toUpperCase();
                boolean pagardeuda = respuestaPago.startsWith("V") || respuestaPago.equals("TRUE") || respuestaPago.equals("1");

                if (pagardeuda) {
                    deuda -= pago;
                    saldo -= pago;
                    
                    
                    for (int i = 1; i <= 4; i++) {
                        System.out.println("iniciando siguiente ronda");
                        if (i == 1) System.out.println("=====                    ");
                        else if (i == 2) System.out.println("============             ");
                        else if (i == 3) System.out.println("===================      ");
                        else System.out.println("=========================");
                        
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        clearScreen();
                    }
                } else {
                    System.out.println("=================================================");
                    System.out.println("Sin pago no hay mañana. Las sombras te alcanzaron.");
                    System.out.println("                 GAME OVER                       ");
                    System.out.println("=================================================");
                    saldo = 0;
                }
            }
        } while (deuda > 0);

        if (deuda < 0){
            System.out.println("===============================================");
            System.out.println("Felicidades eres libre para ver un nuevo mañana");
            System.out.println("===============================================");
        }

        scanner.close();
    }

    
    private static void clearScreen() {
        for (int i = 0; i < 1; i++) {
            System.out.println();
        }
    }
}
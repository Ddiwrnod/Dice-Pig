/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

/**
 *
 * @author Nelson
 */
public class Dice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int acumulado=0, dado1, dado2;
        String nombre;
        System.out.println("Bienvenido a Pig \n"
                + "El juego consiste en lanzar dos dados, si no da 1 en ningun dado, el valor de estos se sumará al marcador general\n"
                + "Al ser así usted podrá elegir entre lanzar de nuevo o pasar\n"
                + "Si lanza de nuevo y da 1 en algun dado su marcador se perdera y no sumara en el marcador general, ademas cedera el turno a la maquina\n"
                + "Si en cualquier momento del juego lanza y da 1 1 su marcador general volverá a 0 y cedera el turno a la maquina\n"
                + "Al pasar le cede el turno a la maquina\n"
                + "El primero en llegar a 100 puntos, gana\n\n"
                + "Ingrese su nombre");
        java.util.Scanner lectura = new java.util.Scanner(System.in);
        nombre = lectura.next();
        boolean a=false;
            int totaljugador =0;
            int totalmaquina =0;
            int decisionmq;
        while (acumulado < 100){
            int totalturnoj=0;
            int totalturnom=0;
            while (a==false){
                System.out.println("Es el turno de "+nombre);
                dado1=(int)(Math.random()*6+1);
                dado2=(int)(Math.random()*6+1);
                if (dado1==1&dado2==1){
                    System.out.println("Lo sentimos "+nombre+", su lanzamiento fue "+dado1+" "+dado2+" su nuevo acumulado total es 0, es el turno de la maquina");
                    int c=2;
                    a= c==2;
                    totaljugador=0;
                    System.out.println("Actualmente "+nombre+" lleva "+totaljugador+" puntos en el juego");
                }else
                if (dado1==1||dado2==1){
                    System.out.println("Lo sentimos "+nombre+", su lanzamiento fue "+dado1+" "+dado2+" su acumulado en este turno es 0, es el turno de la maquina");
                    int b=2;
                    a= b==2;
                    totalturnoj=0;
                    System.out.println("Actualmente "+nombre+" lleva "+totaljugador+" puntos en el juego");
                }else{
                System.out.println(nombre+" su lanzamiento fue "+dado1+" "+dado2+", desea lanzar de nuevo o pasar?");
                totalturnoj=totalturnoj+dado1+dado2;
                System.out.println("(Lanzar/Pasar)");
                java.util.Scanner lectura1 = new java.util.Scanner(System.in);
                String opcion= lectura1.next();
                
                a = dado1==1 ||  dado2==1 || "Pasar".equals(opcion) || "pasar".equals(opcion) || "P".equals(opcion) || "p".equals(opcion);
                
                if(a==true){
                    System.out.println("En este turno acumulo "+totalturnoj);
                    totaljugador=totalturnoj+totaljugador;
                    System.out.println("Actualmente "+nombre+" lleva "+totaljugador+" puntos en el juego");
                   
                }
                }
            }
            a= totaljugador>=100;
            
            
            while (a==false){
                System.out.println("Es el turno de la maquina");
                dado1=(int)(Math.random()*6+1);
                dado2=(int)(Math.random()*6+1);
                if (dado1==1&dado2==1){
                    System.out.println("La maquina ha lanzado "+dado1+" "+dado2+" su nuevo acumulado total es 0, es el turno de "+nombre);
                    int c=2;
                    a= c==2;
                    totaljugador=0;
                    System.out.println("Actualmente "+nombre+" lleva "+totaljugador+" puntos en el juego");
                }else
                if (dado1==1||dado2==1){
                    System.out.println("La maquina ha lanzado "+dado1+" "+dado2+" su acumulado en este turno es 0, es el turno de "+nombre);
                    int b=2;
                    a= b==2;
                    totalturnom=0;
                    System.out.println("Actualmente la maquina lleva "+totalmaquina+" puntos en el juego");
                }else{
                System.out.println("La maquina ha lanzado "+dado1+" "+dado2);
                totalturnom=totalturnom+dado1+dado2;
                decisionmq=(int)(Math.random()*2+1);
                
                a = dado1==1 ||  dado2==1 || decisionmq==2;
                
                if(a==true){
                    System.out.println("La maquina ha decidido pasar, y en este turno acumulo "+totalturnom);
                    totalmaquina=totalturnom+totalmaquina;
                    System.out.println("Actualmente la maquina lleva "+totalmaquina+" puntos en el juego");
                    
                }
                }
            }
            a=false;
            if (totalmaquina>totaljugador){
                acumulado=totalmaquina;
            }
            else
                acumulado=totaljugador;
            }
        if (acumulado==totalmaquina){
            System.out.println("La maquina ha ganado");
        } else if (acumulado==totaljugador){
            System.out.println("FELICIDADES!!! "+nombre+" es el ganador");
        }
    }
    
}

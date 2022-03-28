 /*  PROJETO E OTIMIZAÇÃO DE ALGORITMOS
    Prof. João Batista
    Turma 010
    Morgana Weber
    Trabalho Prático 1
*/

import java.util.Scanner;

public class App {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        
        //Lê os valores 
        System.out.println("###### Karatsuba Mortal Triplo Carpado #####");
        System.out.println("Digite os dois valores separados por espaço: ");

        String values = in.nextLine();

        //Cria o objeto e chama os métodos
        KaratsubaTriplo kt = new KaratsubaTriplo();
        System.out.println(kt.karaTriplo(values));
        in.close();
    }
}
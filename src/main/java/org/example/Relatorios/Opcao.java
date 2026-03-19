package org.example.Relatorios;
import java.util.Scanner;

public class Opcao {
    public static int Mostrar_Opcao(){
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------");
        System.out.println("Sair=0");
        System.out.println("Satelite=1");
        System.out.println("Foguete=2");
        System.out.println("Equipe=3");
        System.out.println("Astronautas=4");
        System.out.println("Missao=4");
        System.out.println("-----------------------------");

        System.out.println("Escolha uma opção:");
        int resposta = input.nextInt();
        if(resposta == 0){
            System.out.print("Encerrando");
            System.exit(0);
        }
        return resposta;
    }
}

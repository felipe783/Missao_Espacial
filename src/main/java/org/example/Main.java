package org.example;

import org.example.Objetos.*;
import org.example.Relatorios.*;
import org.example.Missao.*;
import org.example.Objetos.*;

import java.util.Scanner;

public class Main{
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        //Criacao.Mostrar(); //Pra criar os satelites e Foguetes
        System.out.println("=========================");
        System.out.println("1-Mostrar Satelites/Foguete");
        System.out.println("2-Iniciar Missão");
        System.out.println("3-Ver Missões");
        System.out.println("4-Cadastrar Sat/Fog");
        System.out.println("=========================");
        System.out.println("O que deseja fazer?");
        int resposta = input.nextInt();
        switch(resposta){
            case 1: //Mostrar os relatorios
                resposta = Opcao.Mostrar_Opcao();
                Relatorio.Relatorios_Mostrar(resposta);
                Pesquisar_ID.Pesquisar(resposta);
                break;
            case 2:
                Missao_Geral.Mostrar_SatFog();
                Missao_Geral.Cadastrar_Missao();
                break;
            case 3:

                break;
            case 4:
                Criacao.Mostrar();
                break;
        }
    }
}
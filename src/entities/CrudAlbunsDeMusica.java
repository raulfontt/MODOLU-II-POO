package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudAlbunsDeMusica {
    private List<AlbunsDeMusica> listaDeMusicas = new ArrayList<AlbunsDeMusica>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeMusicas(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sess�o de Alb�ns de M�sica.");
        System.out.println("Selecione uma op��o: ");
        System.out.println("01. Ver m�sicas");
        System.out.println("02. Adicionar m�sicas");
        System.out.println("03. Alterar m�sicas");
        System.out.println("04. Remover m�sicas");
        System.out.println("05. Comprar m�sicas");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public static void cadastrarMusicas(){


    }





}//Final do CRUD

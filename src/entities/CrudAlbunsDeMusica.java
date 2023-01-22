package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudAlbunsDeMusica {
    private List<AlbunsDeMusica> listaDeMusicas = new ArrayList<AlbunsDeMusica>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeMusicas(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sessão de Albúns de Música.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Ver músicas");
        System.out.println("02. Adicionar músicas");
        System.out.println("03. Alterar músicas");
        System.out.println("04. Remover músicas");
        System.out.println("05. Comprar músicas");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public static void cadastrarMusicas(){


    }





}//Final do CRUD

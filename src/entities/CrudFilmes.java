package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudFilmes {
    private List<Filmes> listaDeFilmes = new ArrayList<Filmes>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeFilmes(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sessão de Filmes.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Ver filmes");
        System.out.println("02. Adicionar filmes");
        System.out.println("03. Alterar filmes");
        System.out.println("04. Remover Filmes");
        System.out.println("05. Comprar filmes");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public List<Filmes> getListaDeFilmes() {
        return listaDeFilmes;
    }

    public static Filmes cadastrarFilme(Scanner sc, int contID){
        Filmes filmes = new Filmes();
        System.out.println("Digite o nome do Filme: ");
        filmes.setNome(sc.nextLine());
        System.out.println("Digite o preco do Filme: ");
        filmes.setPreco(sc.nextDouble());
        System.out.println("Digite o estudio do Filme: ");
        sc.nextLine();
        filmes.setEstudio(sc.nextLine());
        System.out.println("Digite o Diretores: ");
        filmes.setDiretores(sc.nextLine());
        System.out.println("Digite o Genero: ");
        filmes.setGenero(sc.nextLine());
        filmes.setId(contID++);
        return filmes;
    }

    public void listarFilmes () {
        listaDeFilmes.forEach((p) -> {
            System.out.print("Nome do Jogo: " + p.getNome());
            System.out.print("/ID: " + p.getId());
            System.out.print("/Preco: " + p.getPreco());
            System.out.print("/Estudio: " + p.getEstudio());
            System.out.print("/Diretores: " + p.getDiretores());
            System.out.print("/Genero: " + p.getGenero());
            System.out.println("");
        });


    }


}//final

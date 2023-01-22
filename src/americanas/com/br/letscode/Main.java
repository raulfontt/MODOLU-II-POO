package americanas.com.br.letscode;

import entities.*;

import java.util.Scanner;

public class Main {

    static int opcaoEscolhida = 0; //Variável que sempre irá chamar o Menu
    public static Integer contID = 0;

    public static int menuPrincipal(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo a Americanas Story.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Menu de Livros");
        System.out.println("02. Menu de Jogos");
        System.out.println("03. Menu de Filmes");
        System.out.println("04. Menu de Albúns de Música");
        System.out.println("05. Menu de Brinquedos");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public static void main(String[] args) {
        // Variável para receber dados:
        Scanner sc = new Scanner(System.in);
        boolean valida = true;
        boolean validaMenuPrincipal = true;

        //Declaração das classes
        Livros livrosStore = new Livros();
        CrudLivros crudLivros = new CrudLivros();

        Jogos listaDeJogos = new Jogos();
        CrudJogos crudJogos = new CrudJogos();

        Filmes listaDeFilmes = new Filmes();
        CrudFilmes crudFilmes = new CrudFilmes();

        AlbunsDeMusica albunsDeMusica = new AlbunsDeMusica();
        CrudAlbunsDeMusica crudAlbunsDeMusica = new CrudAlbunsDeMusica();

        //Valor no estoque
        double dinheiroEmCaixaDaEmpresa = 1000.00;

        do{
            //Menu Principal
            opcaoEscolhida = menuPrincipal(opcaoEscolhida);

            if(opcaoEscolhida == 1){//Menu de Livros com o CrudLivros

                do{ //Opções do Menu de Livros com Crud
                    opcaoEscolhida = crudLivros.menuDeLivros(opcaoEscolhida);
                    if (opcaoEscolhida == 1){
                        if (crudLivros.getListaDeLivros().isEmpty()){
                            System.out.println("Não tenho livros cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudLivros.listarLivros();
                        }
                    }else if (opcaoEscolhida == 2){
                        livrosStore = crudLivros.cadastrarLivro(sc,contID);
                        contID++;
                        crudLivros.adicionarLivros(livrosStore);
                    } else if (opcaoEscolhida == 3){
                        if (crudLivros.getListaDeLivros().isEmpty()){
                            System.out.println("Não tenho livros cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudLivros.listarLivros();
                            crudLivros.alterarLivros(livrosStore);
                        }
                    }else if (opcaoEscolhida == 4) {
                        if (crudLivros.getListaDeLivros().isEmpty()){
                            System.out.println("Não tenho livros cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudLivros.listarLivros();
                            crudLivros.removerLivros(livrosStore);
                        }

                    }else if (opcaoEscolhida == 5){
                        if (crudLivros.getListaDeLivros().isEmpty()){
                            System.out.println("Não tenho livros cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudLivros.listarLivros();
                            dinheiroEmCaixaDaEmpresa = crudLivros.vendaLivros(livrosStore, dinheiroEmCaixaDaEmpresa);
                            System.out.println("Dinheiro disponível em caixa após a venda: "+ dinheiroEmCaixaDaEmpresa);
                        }

                    }else if(opcaoEscolhida == 6){
                        valida = false;
                    }else{
                        System.out.println("Digite um valor válido");
                    }
                }while(valida);
                valida = true;

                //Menu de Jogos com o CRUD
            }else if (opcaoEscolhida == 2) {
                do{
                    opcaoEscolhida = crudJogos.menuDeJogos(opcaoEscolhida);
                    if (opcaoEscolhida == 1){
                        if (crudJogos.getListaDeJogos().isEmpty()){
                            System.out.println("Não tenho jogos cadastrados. Por favor cadastre um jogo!");
                        }else {
                            crudJogos.listarJogos();
                        }

                    }else if (opcaoEscolhida == 2){
                        listaDeJogos = crudJogos.cadastrarJogo(sc, contID);
                        contID++;
                        crudJogos.adicionarJogos(listaDeJogos);
                    }else if (opcaoEscolhida == 3){
                        if (crudJogos.getListaDeJogos().isEmpty()){
                            System.out.println("Não tenho jogos cadastrados. Por favor cadastre um jogo!");
                        }else {
                            crudJogos.listarJogos();
                            crudJogos.alterarJogos(listaDeJogos);
                        }

                    }else if (opcaoEscolhida == 4){
                        if (crudJogos.getListaDeJogos().isEmpty()){
                            System.out.println("Não tenho jogos cadastrados. Por favor cadastre um jogo!");
                        }else {
                            crudJogos.listarJogos();
                            crudJogos.removerJogos(listaDeJogos);
                        }

                    }else if (opcaoEscolhida == 5){
                        if (crudJogos.getListaDeJogos().isEmpty()){
                            System.out.println("Não tenho jogos cadastrados. Por favor cadastre um jogo!");
                        }else {
                            crudJogos.listarJogos();
                            dinheiroEmCaixaDaEmpresa = crudJogos.vendaJogos(listaDeJogos, dinheiroEmCaixaDaEmpresa);
                            System.out.println("Dinheiro disponível em caixa após a venda: " + dinheiroEmCaixaDaEmpresa);
                        }

                    }else if (opcaoEscolhida == 6){
                        valida = false;
                    }else
                        System.out.println("Digite um valor válido!");
                }while (valida);
                valida = true;

            }else if (opcaoEscolhida == 3) {
                //Menu de Filmes com o CRUD
                do{
                    opcaoEscolhida = crudFilmes.menuDeFilmes(opcaoEscolhida);

                    if (opcaoEscolhida == 1){
                        if (crudFilmes.getListaDeFilmes().isEmpty()){
                            System.out.println("Não tenho filmes cadastrados. Por favor cadastre um filme!");
                        }else {
                            crudFilmes.listarFilmes();
                        }
                    }else if (opcaoEscolhida == 2){
                        listaDeFilmes = crudFilmes.cadastrarFilme(sc, contID);
                        contID++;
                        crudFilmes.adicionarFilmes(listaDeFilmes);

                    }else if (opcaoEscolhida == 3){
                        if (crudFilmes.getListaDeFilmes().isEmpty()){
                            System.out.println("Não tenho filmes cadastrados. Por favor cadastre um filme!");
                        }else {
                            crudFilmes.listarFilmes();
                            crudFilmes.alterarFilmes(listaDeFilmes);
                        }
                    }else if (opcaoEscolhida == 4){
                        if (crudFilmes.getListaDeFilmes().isEmpty()){
                            System.out.println("Não tenho filmes cadastrados. Por favor cadastre um filme!");
                        }else {
                            crudFilmes.listarFilmes();
                            crudFilmes.removerFilmes(listaDeFilmes);
                        }

                    }else if (opcaoEscolhida == 5){
                        if (crudFilmes.getListaDeFilmes().isEmpty()){
                            System.out.println("Não tenho jogos cadastrados. Por favor cadastre um jogo!");
                        }else {
                            crudFilmes.listarFilmes();
                            dinheiroEmCaixaDaEmpresa = crudFilmes.vendaFilmes(listaDeFilmes, dinheiroEmCaixaDaEmpresa);
                            System.out.println("Dinheiro disponível em caixa após a venda: " + dinheiroEmCaixaDaEmpresa);
                        }

                    }else if (opcaoEscolhida == 6){
                        valida = false;
                    }

                }while (valida);
                valida = true;

            }else if (opcaoEscolhida == 4) {
                //Menu de opções do Albúns de Músicas com CRUD
                opcaoEscolhida = crudAlbunsDeMusica.menuDeMusicas(opcaoEscolhida);
                do{
                    if (opcaoEscolhida == 1){

                    }else if (opcaoEscolhida == 2){


                    }


                }while (valida);
                valida = true;

            }else if (opcaoEscolhida == 5) {
                do{

                }while (valida);
                valida = true;
            }else if(opcaoEscolhida == 6){
                validaMenuPrincipal = false;
            }else
                System.out.println("Digite uma das opções do Menu!");

        }while(validaMenuPrincipal);

        System.out.println("Obrigado por nos visitar. Volte sempre!");

        sc.close();
        }

}

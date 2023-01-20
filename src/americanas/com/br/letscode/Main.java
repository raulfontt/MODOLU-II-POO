package americanas.com.br.letscode;

import entities.*;

import java.util.Scanner;

public class Main {

    static int opcaoEscolhida = 0; //Vari�vel que sempre ir� chamar o Menu
    public static Integer contID = 0;

    public static int menuPrincipal(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo a Americanas Story.");
        System.out.println("Selecione uma op��o: ");
        System.out.println("01. Menu de Livros");
        System.out.println("02. Menu de Jogos");
        System.out.println("03. Menu de Filmes");
        System.out.println("04. Menu de Alb�ns de M�sica");
        System.out.println("05. Menu de Brinquedos");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public static void main(String[] args) {
        // Vari�vel para receber dados:
        Scanner sc = new Scanner(System.in);
        boolean valida = true;

        //Declara��o das classes
        Livros livrosStore = new Livros();
        CrudLivros crudLivros = new CrudLivros();

        Jogos listaDeJogos = new Jogos();
        CrudJogos crudJogos = new CrudJogos();

        Filmes listaDeFilmes = new Filmes();
        CrudFilmes crudFilmes = new CrudFilmes();

        //Valor no estoque
        double dinheiroEmCaixaDaEmpresa = 1000.00;

        do{
            //Menu Principal
            opcaoEscolhida = menuPrincipal(opcaoEscolhida);

            if(opcaoEscolhida == 1){//Menu de Livros com o CrudLivros

                do{ //Op��es do Menu de Jogos
                    opcaoEscolhida = crudLivros.menuDeLivros(opcaoEscolhida);
                    if (opcaoEscolhida == 1){
                        if (crudLivros.getListaDeLivros().isEmpty()){
                            System.out.println("N�o tenho livros cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudLivros.listarLivros();
                        }
                    }else if (opcaoEscolhida == 2){
                        livrosStore = crudLivros.cadastrarLivro(sc,contID);
                        contID++;
                        crudLivros.adicionarLivros(livrosStore);
                    } else if (opcaoEscolhida == 3){
                        crudLivros.alterarLivros(livrosStore);

                    }else if (opcaoEscolhida == 4) {
                        crudLivros.removerLivros(livrosStore);

                    }else if (opcaoEscolhida == 5){
                        crudLivros.listarLivros();
                        crudLivros.vendaLivros(livrosStore, dinheiroEmCaixaDaEmpresa);
                    }else if(opcaoEscolhida == 6){
                        valida = false;
                    }else{
                        System.out.println("Digite um valor v�lido");
                    }
                }while(valida);

                //Menu de Jogos com o CRUD
            }else if (opcaoEscolhida == 2) {
                do{
                    opcaoEscolhida = crudJogos.menuDeJogos(opcaoEscolhida);
                    if (opcaoEscolhida == 1){
                        if (crudJogos.getListaDeJogos().isEmpty()){
                            System.out.println("N�o tenho jogos cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudJogos.listarJogos();
                        }

                    }else if (opcaoEscolhida == 2){
                        listaDeJogos = crudJogos.cadastrarJogo(sc, contID);
                        contID++;
                        crudJogos.adicionarJogos(listaDeJogos);
                    }else if (opcaoEscolhida == 3){
                        crudJogos.alterarJogos(listaDeJogos);

                    }else if (opcaoEscolhida == 4){
                        crudJogos.removerJogos(listaDeJogos);

                    }else if (opcaoEscolhida == 5){
                        crudJogos.listarJogos();
                        crudJogos.vendaJogos(listaDeJogos, dinheiroEmCaixaDaEmpresa);
                    }else if (opcaoEscolhida == 6){
                        valida = false;
                    }else
                        System.out.println("Digite um valor v�lido!");
                }while (valida);

            }else if (opcaoEscolhida == 3) {
                //Menu de Filmes com o CRUD
                do{
                    opcaoEscolhida = crudFilmes.menuDeFilmes(opcaoEscolhida);

                    if (opcaoEscolhida == 1){
                        if (crudFilmes.getListaDeFilmes().isEmpty()){
                            System.out.println("N�o tenho jogos cadastrados. Por favor cadastre um livro!");
                        }else {
                            crudFilmes.listarFilmes();
                        }
                    }



                }while (valida);

            }else if (opcaoEscolhida == 4) {
                do{

                }while (valida);

            }else if (opcaoEscolhida == 5) {
                do{

                }while (valida);
            }else if(opcaoEscolhida == 6){
                valida = false;
            }else
                System.out.println("Digite uma das op��es do Menu!");

        }while(valida);

        System.out.println("Obrigado por nos visitar. Volte sempre!");

        sc.close();
        }

}

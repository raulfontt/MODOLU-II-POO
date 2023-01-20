package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrudJogos {
    private List<Jogos> listaDeJogos = new ArrayList<Jogos>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeJogos(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sessão de Jogos.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Ver jogos");
        System.out.println("02. Adicionar jogos");
        System.out.println("03. Alterar jogos");
        System.out.println("04. Remover jogos");
        System.out.println("05. Comprar jogos");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public List<Jogos> getListaDeJogos() {
        return listaDeJogos;
    }

    public static Jogos cadastrarJogo(Scanner sc, int contID){
        Jogos jogo = new Jogos();
        System.out.println("Digite o nome do Jogo: ");
        jogo.setNome(sc.nextLine());
        System.out.println("Digite o preco do Jogo: ");
        jogo.setPreco(sc.nextDouble());
        System.out.println("Digite a Distribuidora: ");
        sc.nextLine();
        jogo.setDistribuidora(sc.nextLine());
        System.out.println("Digite o genero: ");
        jogo.setGenero(sc.nextLine());
        System.out.println("Digite o Estudio: ");
        jogo.setEstudio(sc.nextLine());
        jogo.setId(contID++);
        return jogo;
    }

    public void adicionarJogos(Jogos cp) {
        listaDeJogos.add(cp);
    }

    public void removerJogos(Jogos cp){

        System.out.println("Você deseja remover seu jogo pelo ID ou pelo nome do livro?");
        System.out.println("1. Pelo nome:");
        System.out.println("2. Pelo ID:");
        Integer opcao = sc.nextInt();
        boolean valida =true;

        do {
            if(opcao == 1){
                System.out.println("Qual o nome do Livro você deseja remover? ");
                String nomedoLivroParaExcluir = sc.nextLine();

                List<Jogos> lista = listaDeJogos.stream().filter(listaJogos ->
                        listaJogos.getNome().equals(nomedoLivroParaExcluir)
                ).collect(Collectors.toList());

                listaDeJogos.removeAll(lista);
                valida = false;

            }else if(opcao == 2){
                System.out.println("Qual o ID do livro que você quer remover? ");
                Integer idParaExcluir = sc.nextInt();

                List<Jogos> lista = listaDeJogos.stream().filter(listaJogos ->
                        listaJogos.getId().equals(idParaExcluir)
                ).collect(Collectors.toList());

                listaDeJogos.removeAll(lista);
                valida = false;
            }else
                System.out.println("Digite uma oppção valida");

        }while(valida);
    }

    public void alterarJogos (Jogos cp){
        boolean valida = true;
        System.out.println("Digite o nome do Livro que deseja alterar dados:");//Escolhi fazer a busca da alteração apenas por nome.
        String nomeProdutoAlterar = sc.nextLine();

        do {
            System.out.println("O que você deseja alterar no seu Jogo: ");
            System.out.println("01.Nome do Jogo / 02. Preço ");
            Integer opcao = sc.nextInt();


            if(opcao == 1){
                System.out.println("Digite o nome que substituirá o atual:");
                sc.nextLine();
                String nomeAtualizado = sc.nextLine();
                for (Jogos objetoListaJogo : listaDeJogos) {
                    if (nomeProdutoAlterar.equals(objetoListaJogo.getNome())) {
                        objetoListaJogo.setNome(nomeAtualizado);//alterado preço do produto
                        System.out.println(objetoListaJogo.getNome());
                    }
                }
                valida = false;

            }else if (opcao == 2) {
                System.out.println("Digite o valor preço que substituirá o atual:");
                double valorAtualizado = sc.nextDouble();
                for (Jogos objetoListaJogo : listaDeJogos) {
                    if (nomeProdutoAlterar.equals(objetoListaJogo.getNome())) {
                        objetoListaJogo.setPreco(valorAtualizado);//alterado preço do produto
                        System.out.println(objetoListaJogo.getPreco());
                    }
                }
                valida = false;
            }else {
                System.out.println("Opção Inválida. Digite novamente");
            }

        }while (valida);
    }

    public void vendaJogos(Jogos cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o nome do Livro você deseja comprar? ");
        String nomeProdutoCompra = sc.nextLine();

        for (Jogos objetoListaJogo: listaDeJogos) {
            if (nomeProdutoCompra.equals(objetoListaJogo.getNome())) {
                listaDeJogos.remove(objetoListaJogo);//retirado do estoque
                dinheiroEmCaixaDaEmpresa = dinheiroEmCaixaDaEmpresa + objetoListaJogo.getPreco();//valor pago adicionado ao caixa da empresa
            }
        }
    }

    public void listarJogos (){
        listaDeJogos.forEach((p) -> {
            System.out.print("Nome do Jogo: " + p.getNome());
            System.out.print("/ID: " + p.getId());
            System.out.print("/Preco: " + p.getPreco());
            System.out.print("/Distribuidora: " + p.getDistribuidora());
            System.out.print("/Estudio: " + p.getEstudio());
            System.out.print("/Genero: " + p.getGenero());
            System.out.println("");
        } );
    }



}

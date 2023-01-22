package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrudFilmes {
    private List<Filmes> listaDeFilmes = new ArrayList<Filmes>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeFilmes(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sess�o de Filmes.");
        System.out.println("Selecione uma op��o: ");
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

    public void adicionarFilmes(Filmes cp) {
        listaDeFilmes.add(cp);
    }

    public void alterarFilmes (Filmes cp){
        boolean valida = true;

        System.out.println("Digite o ID do Filme que deseja alterar: ");//Altera��o pelo ID
        Integer idProdutoAlterar = sc.nextInt();

        Filmes result = listaDeFilmes.stream()
                .filter(filme -> filme.getId().equals(idProdutoAlterar))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        do { //Nova solu��o exposta em sala, atrav�s do fun��o da lista usando Stream() e Filter();
            System.out.println("O que voc� deseja alterar no seu Filme: ");
            System.out.println("01.Nome do Filme / 02. Pre�o ");
            Integer opcao = sc.nextInt();


            if(opcao == 1){
                System.out.println("Digite o nome que substituir� o atual:");
                sc.nextLine();
                String nomeAtualizado = sc.nextLine();
                result.setNome(nomeAtualizado);
                valida = false;

            }else if (opcao == 2) {
                System.out.println("Digite o valor pre�o que substituir� o atual:");
                double valorAtualizado = sc.nextDouble();
                result.setPreco(valorAtualizado);
                valida = false;
            }else {
                System.out.println("Op��o Inv�lida. Voc� s� pode alterar Nome ou Pre�o. Digite novamente");
            }
        }while (valida);
    }

    public void removerFilmes(Filmes cp){//Solu��o de remo��o � melhor removendo pelo ID
        boolean valida =true;
        do {
            if(valida){
                System.out.println("Qual ID do Livro?");
                System.out.print("ID: ");
                Integer opcao = sc.nextInt();

                List<Filmes> lista = listaDeFilmes.stream().filter(listaJogos ->
                        listaJogos.getId().equals(opcao)
                ).collect(Collectors.toList());

                listaDeFilmes.removeAll(lista);
                valida = false;

            }else
                System.out.println("Digite uma opp��o valida");

        }while(valida);
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

    public double vendaFilmes(Filmes cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o ID do filme voc� deseja comprar? ");
        Integer idProdutoCompra = sc.nextInt();

        Filmes result = listaDeFilmes.stream()
                .filter(filme -> filme.getId().equals(idProdutoCompra))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        List<Filmes> lista = listaDeFilmes.stream().filter(listaJogos ->
                listaJogos.getId().equals(idProdutoCompra)
        ).collect(Collectors.toList());

        listaDeFilmes.removeAll(lista);

    return dinheiroEmCaixaDaEmpresa + result.getPreco();
    }

}//final

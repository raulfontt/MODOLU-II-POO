package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrudAlbunsDeMusica {
    private static List<AlbunsDeMusica> listaDeMusicas = new ArrayList<AlbunsDeMusica>();
    static Scanner sc = new Scanner(System.in);

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

    public static AlbunsDeMusica cadastrarMusicas(Scanner sc, int contID){
        AlbunsDeMusica albunsDeMusica = new AlbunsDeMusica();
        System.out.println("Digite o nome da M�sica: ");
        albunsDeMusica.setNome(sc.nextLine());
        System.out.println("Digite o preco da M�sica: ");
        albunsDeMusica.setPreco(sc.nextDouble());
        sc.nextLine();
        System.out.println("Digite o m�sico ou Banda da M�sica: ");
        albunsDeMusica.setMusicosBanda(sc.nextLine());
        System.out.println("Digite g�nero da m�sica: ");
        albunsDeMusica.setGeneroMusica(sc.nextLine());
        albunsDeMusica.setId(contID++);

        return albunsDeMusica;
    }

    public void adicionarMusicas(AlbunsDeMusica cp) {
        listaDeMusicas.add(cp);
    }

    public List<AlbunsDeMusica> getListaDeMusicas() {
        return listaDeMusicas;
    }

    public void alterarAlbumDeMusicas (AlbunsDeMusica cp){
        boolean valida = true;

        System.out.println("Digite o ID da M�sica que deseja alterar: ");//Altera��o pelo ID
        Integer idProdutoAlterar = sc.nextInt();

        AlbunsDeMusica result = listaDeMusicas.stream()
                .filter(musica -> musica.getId().equals(idProdutoAlterar))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        do { //Nova solu��o exposta em sala, atrav�s do fun��o da lista usando Stream() e Filter();
            System.out.println("O que voc� deseja alterar na sua M�sica: ");
            System.out.println("01.Nome da M�sica / 02. Pre�o ");
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

    public void removerAlbumDeMusicas(AlbunsDeMusica cp){//Solu��o de remo��o � melhor removendo pelo ID
        boolean valida =true;
        do {
            if(valida){
                System.out.println("Qual ID da M�sica?");
                System.out.print("ID: ");
                Integer opcao = sc.nextInt();

                List<AlbunsDeMusica> lista = listaDeMusicas.stream().filter(listaJogos ->
                        listaJogos.getId().equals(opcao)
                ).collect(Collectors.toList());

                listaDeMusicas.removeAll(lista);
                valida = false;
            }else
                System.out.println("Digite uma opp��o valida");

        }while(valida);
    }

    public double vendaMusica(AlbunsDeMusica cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o ID do filme voc� deseja comprar? ");
        Integer idProdutoCompra = sc.nextInt();

        AlbunsDeMusica result = listaDeMusicas.stream()
                .filter(filme -> filme.getId().equals(idProdutoCompra))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        List<AlbunsDeMusica> lista = listaDeMusicas.stream().filter(listaJogos ->
                listaJogos.getId().equals(idProdutoCompra)
        ).collect(Collectors.toList());

        listaDeMusicas.removeAll(lista);

        return dinheiroEmCaixaDaEmpresa + result.getPreco();
    }

    public void listarMusicas () {
        listaDeMusicas.forEach((p) -> {
            System.out.print("Nome do Jogo: " + p.getNome());
            System.out.print("/ID: " + p.getId());
            System.out.print("/Preco: " + p.getPreco());
            System.out.print("/M�sico ou Banda: " + p.getMusicosBanda());
            System.out.print("/Genero: " + p.getGeneroMusica());
            System.out.println("");
        });
    }






}//Final do CRUD

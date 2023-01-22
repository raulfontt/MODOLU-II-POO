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

    public static AlbunsDeMusica cadastrarMusicas(Scanner sc, int contID){
        AlbunsDeMusica albunsDeMusica = new AlbunsDeMusica();
        System.out.println("Digite o nome da Música: ");
        albunsDeMusica.setNome(sc.nextLine());
        System.out.println("Digite o preco da Música: ");
        albunsDeMusica.setPreco(sc.nextDouble());
        sc.nextLine();
        System.out.println("Digite o músico ou Banda da Música: ");
        albunsDeMusica.setMusicosBanda(sc.nextLine());
        System.out.println("Digite gênero da música: ");
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

        System.out.println("Digite o ID da Música que deseja alterar: ");//Alteração pelo ID
        Integer idProdutoAlterar = sc.nextInt();

        AlbunsDeMusica result = listaDeMusicas.stream()
                .filter(musica -> musica.getId().equals(idProdutoAlterar))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        do { //Nova solução exposta em sala, através do função da lista usando Stream() e Filter();
            System.out.println("O que você deseja alterar na sua Música: ");
            System.out.println("01.Nome da Música / 02. Preço ");
            Integer opcao = sc.nextInt();

            if(opcao == 1){
                System.out.println("Digite o nome que substituirá o atual:");
                sc.nextLine();
                String nomeAtualizado = sc.nextLine();
                result.setNome(nomeAtualizado);
                valida = false;

            }else if (opcao == 2) {
                System.out.println("Digite o valor preço que substituirá o atual:");
                double valorAtualizado = sc.nextDouble();
                result.setPreco(valorAtualizado);
                valida = false;
            }else {
                System.out.println("Opção Inválida. Você só pode alterar Nome ou Preço. Digite novamente");
            }
        }while (valida);
    }

    public void removerAlbumDeMusicas(AlbunsDeMusica cp){//Solução de remoção é melhor removendo pelo ID
        boolean valida =true;
        do {
            if(valida){
                System.out.println("Qual ID da Música?");
                System.out.print("ID: ");
                Integer opcao = sc.nextInt();

                List<AlbunsDeMusica> lista = listaDeMusicas.stream().filter(listaJogos ->
                        listaJogos.getId().equals(opcao)
                ).collect(Collectors.toList());

                listaDeMusicas.removeAll(lista);
                valida = false;
            }else
                System.out.println("Digite uma oppção valida");

        }while(valida);
    }

    public double vendaMusica(AlbunsDeMusica cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o ID do filme você deseja comprar? ");
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
            System.out.print("/Músico ou Banda: " + p.getMusicosBanda());
            System.out.print("/Genero: " + p.getGeneroMusica());
            System.out.println("");
        });
    }






}//Final do CRUD

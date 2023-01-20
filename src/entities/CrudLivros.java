package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrudLivros {
    private List<Livros> listaDeLivros = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public static int menuDeLivros(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sessão de Livros.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Ver livros");
        System.out.println("02. Adicionar livros");
        System.out.println("03. Alterar livros");
        System.out.println("04. Remover livros");
        System.out.println("05. Comprar livros");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public List<Livros> getListaDeLivros() {
        return listaDeLivros;
    }

    public static Livros cadastrarLivro(Scanner sc, int contID){
        Livros livro = new Livros();
        System.out.println("Digite o nome do livro: ");
        livro.setNome(sc.nextLine());
        System.out.println("Digite o preco do livro: ");
        livro.setPreco(sc.nextDouble());
        System.out.println("Digite o autor do livro: ");
        sc.nextLine();
        livro.setEscritor(sc.nextLine());
        System.out.println("Digite o genero do livro: ");
        livro.setEditora(sc.nextLine());
        System.out.println("Digite a editora do livro: ");
        livro.setGeneros(sc.nextLine());
        livro.setId(contID++);
        return livro;
    }

    public void adicionarLivros(Livros cp) {
        listaDeLivros.add(cp);
    }

    public void alterarLivros (Livros cp){
        boolean valida = true;System.out.println("Digite o nome do Livro que deseja alterar dados:");//Escolhi fazer a busca da alteração apenas por nome.
        String nomeProdutoAlterar = sc.nextLine();


        do {
            System.out.println("O que você deseja alterar no seu Livro: ");
            System.out.println("01.Nome do Livro / 02. Preço / 03.Genero / 04. Escritor / 05. Editora");
            Integer opcao = sc.nextInt();


            if(opcao == 1){
                System.out.println("Digite o nome que substituirá o atual:");
                sc.nextLine();
                String nomeAtualizado = sc.nextLine();
                for (Livros objetoListaLivro : listaDeLivros) {
                    if (nomeProdutoAlterar.equals(objetoListaLivro.getNome())) {
                        objetoListaLivro.setNome(nomeAtualizado);//alterado preço do produto
                        System.out.println(objetoListaLivro.getNome());
                    }
                }
                valida = false;

            }else if (opcao == 2){
                System.out.println("Digite o valor preço que substituirá o atual:");
                double valorAtualizado = sc.nextDouble();
                for (Livros objetoListaLivro : listaDeLivros) {
                    if (nomeProdutoAlterar.equals(objetoListaLivro.getNome())) {
                        objetoListaLivro.setPreco(valorAtualizado);//alterado preço do produto
                        System.out.println(objetoListaLivro.getPreco());
                    }
                }
                valida = false;
            }else if (opcao == 3){
                System.out.println("Digite o Genero que substituirá o atual:");
                sc.nextLine();
                String generoAtualizado = sc.nextLine();
                for (Livros objetoListaLivro : listaDeLivros) {
                    if (nomeProdutoAlterar.equals(objetoListaLivro.getGeneros())) {
                        objetoListaLivro.setGeneros(generoAtualizado);//alterado preço do produto
                        System.out.println(objetoListaLivro.getGeneros());//Só para conferir o valor
                    }
                }
                valida = false;
            }else if (opcao == 4){
                System.out.println("Digite o Escritor que substituirá o atual:");
                sc.nextLine();
                String editoraAtualizado = sc.nextLine();
                for (Livros objetoListaLivro : listaDeLivros) {
                    if (nomeProdutoAlterar.equals(objetoListaLivro.getGeneros())) {
                        objetoListaLivro.setEditora(editoraAtualizado);//alterado preço do produto
                        System.out.println(objetoListaLivro.getEditora());//Só para conferir o valor
                    }
                }
                valida = false;
            }
                System.out.println("Opção Inválida. Digite novamente");

        }while (valida);
    }

    public void removerLivros(Livros cp){

        System.out.println("Você deseja remover seu livro pelo ID ou pelo nome do livro?");
        System.out.println("1. Pelo nome:");
        System.out.println("2. Pelo ID:");
        Integer opcao = sc.nextInt();

        if(opcao == 1){
            System.out.println("Qual o nome do Livro você deseja remover? ");
            String nomedoLivroParaExcluir = sc.nextLine();

            List<Livros> lista = listaDeLivros.stream().filter(listaLivros ->
                    listaLivros.getNome().equals(nomedoLivroParaExcluir)
            ).collect(Collectors.toList());

            listaDeLivros.removeAll(lista);

        }else{
            System.out.println("Qual o ID do livro que você quer remover? ");
            Integer idParaExcluir = sc.nextInt();

            List<Livros> lista = listaDeLivros.stream().filter(listaLivros ->
                    listaLivros.getId().equals(idParaExcluir)
            ).collect(Collectors.toList());

            listaDeLivros.removeAll(lista);
        }
    }

    public void vendaLivros(Livros cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o nome do Livro você deseja comprar? ");
        String nomeProdutoCompra = sc.nextLine();

        for (Livros objetoListaLivro: listaDeLivros) {
            if (nomeProdutoCompra.equals(objetoListaLivro.getNome())) {
                listaDeLivros.remove(objetoListaLivro);//retirado do estoque
                dinheiroEmCaixaDaEmpresa = dinheiroEmCaixaDaEmpresa + objetoListaLivro.getPreco();//valor pago adicionado ao caixa da empresa
            }
        }


    }

    public void listarLivros (){
        listaDeLivros.forEach((p) -> {
            System.out.print("Nome do livro: " + p.getNome());
            System.out.print("/ID: " + p.getId());
            System.out.print("/Preco: " + p.getPreco());
            System.out.print("/Genero: " + p.getGeneros());
            System.out.print("/Escritor: " + p.getEscritor());
            System.out.print("/Editora: " + p.getEditora());
            System.out.println("");
        } );
    }
}

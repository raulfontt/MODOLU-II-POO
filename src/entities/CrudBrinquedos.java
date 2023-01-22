package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrudBrinquedos {
    private static List<Brinquedos> listaDeBrinquedos = new ArrayList<Brinquedos>();
    static Scanner sc = new Scanner(System.in);

    public static int menuDeBrinquedos(int numEscolhido){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sessão de Brinquedos.");
        System.out.println("Selecione uma opção: ");
        System.out.println("01. Ver brinquedos");
        System.out.println("02. Adicionar brinquedos");
        System.out.println("03. Alterar brinquedos");
        System.out.println("04. Remover brinquedos");
        System.out.println("05. Comprar brinquedos");
        System.out.println("06. Sair");
        return numEscolhido = sc.nextInt();
    }

    public static Brinquedos cadastrarBrinquedos(Scanner sc, int contID){
        Brinquedos brinquedo = new Brinquedos();
        System.out.println("Digite o nome da Brinquedo: ");
        brinquedo.setNome(sc.nextLine());
        System.out.println("Digite o preco da Brinquedo: ");
        brinquedo.setPreco(sc.nextDouble());
        sc.nextLine();
        System.out.println("Digite o tipo de Brinquedo: ");
        brinquedo.setTipo(sc.nextLine());
        brinquedo.setId(contID++);

        return brinquedo;
    }

    public void adicionarBrinquedos(Brinquedos cp) {
        listaDeBrinquedos.add(cp);
    }

    public List<Brinquedos> getListaDeBrinquedos() {
        return listaDeBrinquedos;
    }

    public void alterarBrinquedo (Brinquedos cp){
        boolean valida = true;

        System.out.println("Digite o ID do brinquedo que deseja alterar: ");//Alteração pelo ID
        Integer idProdutoAlterar = sc.nextInt();

        Brinquedos result = listaDeBrinquedos.stream()
                .filter(musica -> musica.getId().equals(idProdutoAlterar))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        do { //Nova solução exposta em sala, através do função da lista usando Stream() e Filter();
            System.out.println("O que você deseja alterar no seu brinquedo ");
            System.out.println("01.Nome do Brinquedo / 02. Preço ");
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

    public void removerBrinquedo(Brinquedos cp){//Solução de remoção é melhor removendo pelo ID
        boolean valida =true;
        do {
            if(valida){
                System.out.println("Qual ID do Brinquedo?");
                System.out.print("ID: ");
                Integer opcao = sc.nextInt();

                List<Brinquedos> lista = listaDeBrinquedos.stream().filter(listaJogos ->
                        listaJogos.getId().equals(opcao)
                ).collect(Collectors.toList());

                listaDeBrinquedos.removeAll(lista);
                valida = false;
            }else
                System.out.println("Digite uma opção válida");

        }while(valida);
    }

    public double vendaBrinquedo(Brinquedos cp, double dinheiroEmCaixaDaEmpresa){
        System.out.println("Qual o ID do brinquedo você deseja comprar? ");
        Integer idProdutoCompra = sc.nextInt();

        Brinquedos result = listaDeBrinquedos.stream()
                .filter(filme -> filme.getId().equals(idProdutoCompra))
                .collect(Collectors.toList())
                .stream().findFirst().get();

        List<Brinquedos> lista = listaDeBrinquedos.stream().filter(listaJogos ->
                listaJogos.getId().equals(idProdutoCompra)
        ).collect(Collectors.toList());

        listaDeBrinquedos.removeAll(lista);

        return dinheiroEmCaixaDaEmpresa + result.getPreco();
    }

    public void listaBrinquedos () {
        listaDeBrinquedos.forEach((p) -> {
            System.out.print("Nome do brinquedo: " + p.getNome());
            System.out.print("/ID: " + p.getId());
            System.out.print("/Preco: " + p.getPreco());
            System.out.print("/Tipo: " + p.getTipo());
            System.out.println("");
        });
    }
}//final do crud

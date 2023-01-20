package entities;

public class Livros extends ProdutosLoja {
    private String generos;
    private String escritor;
    private String editora;

    public Livros() {
    }

    public Livros(String nome, int id, double preco) {
        super(id, nome, preco);
    }

    public Livros(String nome, int id, double preco, String generos, String escritor, String editora) {
        super(id, nome, preco);
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
    }

    public String getGeneros() {
        return generos;
    }

    public void setGeneros(String generos) {
        this.generos = generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }


}

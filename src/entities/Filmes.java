package entities;

public class Filmes extends ProdutosLoja{
    private String estudio;
    private String diretores;
    private String genero;

    public Filmes(){
    }

    public Filmes(String nome, int id, double preco) {
        super(id, nome, preco);
    }

    public Filmes(Integer id, String nome, double preco, String estudio, String diretores, String genero) {
        super(id, nome, preco);
        this.estudio = estudio;
        this.diretores = diretores;
        this.genero = genero;
    }

    public Filmes(String estudio, String diretores, String genero, String produtores) {
        this.estudio = estudio;
        this.diretores = diretores;
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDiretores() {
        return diretores;
    }

    public void setDiretores(String diretores) {
        this.diretores = diretores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


}

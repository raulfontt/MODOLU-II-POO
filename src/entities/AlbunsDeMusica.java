package entities;

public class AlbunsDeMusica extends ProdutosLoja{
    private String musicosBanda;
    private String generoMusica;

    public AlbunsDeMusica(){
    }

    public AlbunsDeMusica(Integer id, String nome, double preco, String musicosBanda, String generoMusica) {
        super(id, nome, preco);
        this.musicosBanda = musicosBanda;
        this.generoMusica = generoMusica;
    }

    public AlbunsDeMusica(String musicosBanda, String generoMusica) {
        this.musicosBanda = musicosBanda;
        this.generoMusica = generoMusica;
    }

    public String getMusicosBanda() {
        return musicosBanda;
    }

    public void setMusicosBanda(String musicosBanda) {
        this.musicosBanda = musicosBanda;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }
}

package entities;

public class AlbunsDeMusica extends ProdutosLoja{
    private String musicaNome;
    private String generoMusica;

    public AlbunsDeMusica(){
    }

    public AlbunsDeMusica(String nome, int id, double preco) {
        super(id, nome, preco);
    }

    public AlbunsDeMusica(Integer id, String nome, double preco, String musicaNome, String generoMusica) {
        super(id, nome, preco);
        this.musicaNome = musicaNome;
        this.generoMusica = generoMusica;
    }

    public AlbunsDeMusica(String musicaNome, String generoMusica) {
        this.musicaNome = musicaNome;
        this.generoMusica = generoMusica;
    }

    public String getMusicaNome() {
        return musicaNome;
    }

    public void setMusicaNome(String musicaNome) {
        this.musicaNome = musicaNome;
    }

    public String getGeneroMusica() {
        return generoMusica;
    }

    public void setGeneroMusica(String generoMusica) {
        this.generoMusica = generoMusica;
    }
}

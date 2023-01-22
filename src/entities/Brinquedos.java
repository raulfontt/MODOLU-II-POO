package entities;

public class Brinquedos extends ProdutosLoja {
    private String tipo;

    public Brinquedos(){
    }

    public Brinquedos(Integer id, String nome, double preco, String tipo) {
        super(id, nome, preco);
        this.tipo = tipo;
    }

    public Brinquedos(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

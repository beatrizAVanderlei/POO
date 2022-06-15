package desafio;

public class Categoria {
    private String nome;
    private double valor;

    public Categoria(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Categoria){
            return this.nome.equals(((Categoria) o).getNome());
        }
        return false;
    }
}

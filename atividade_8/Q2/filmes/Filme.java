package filmes;

public abstract class Filme {
    private String nome;
    private double valor;

    public Filme(String nome){
        this.nome = nome;
        this.valor = 4.00;
    }

    public double getValor(){
        return this.valor;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public abstract double getPrecoDaLocacao();

}

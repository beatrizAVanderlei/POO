package desafio;
import java.util.ArrayList;

public class Filme {
    private ArrayList<Categoria> categorias;
    private String nome;
    private double valor;

    public Filme(String nome){
        this.nome = nome;
        this.valor = 4.00;
        this.categorias = new ArrayList<Categoria>();
    }

    public void adicionarCategoria (Categoria categoria){
        if(!this.categorias.contains(categoria)){
            this.categorias.add(categoria);
        }
    }

    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return this.valor;
    }

    public double getPrecoDaLocacao() {
        double soma = 0;
        for(Categoria c : this.categorias)
            soma = soma + c.getValor();
        return getValor()+soma;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}

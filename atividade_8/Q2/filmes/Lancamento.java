package filmes;

public class Lancamento extends Filme {
    private double taxa;

    public Lancamento(String n){
        super(n);
        this.taxa = 3.00;
    }

    public double getTaxa(){
        return this.taxa;
    }

    public double getPrecoDaLocacao(){
        return getValor()+getTaxa();
    }
}

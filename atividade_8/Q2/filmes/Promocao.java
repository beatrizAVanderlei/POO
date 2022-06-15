package filmes;

public class Promocao extends Filme{
    private double taxa;

    public Promocao(String n){
        super(n);
        this.taxa = -2.00;
    }

    public double getTaxa(){
        return taxa;
    }

    public double getPrecoDaLocacao() {
        return getValor()+getTaxa();
    }
}

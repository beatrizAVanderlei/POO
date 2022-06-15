package filmes;

public class Infantil extends Filme{
    private double taxa;

    public Infantil(String n){
        super(n);
        this.taxa = 2.00;
    }

    public double getTaxa(){
        return this.taxa;
    }

    public double getPrecoDaLocacao(){
        return getValor()+getTaxa();
    }
}

package pessoas;

public class Homem extends Pessoa{

    public Homem(double a, double p){
        super(a, p);
    }

    @Override
    public String toString() {
        if(this.imc() < 20.7){
            return "Abaixo do peso ideal";
        }
        if((this.imc() > 20.7) && (this.imc() < 26.4)){
            return "Peso ideal";
        }
        else{
            return "Acima do peso ideal";
        }
    }
}

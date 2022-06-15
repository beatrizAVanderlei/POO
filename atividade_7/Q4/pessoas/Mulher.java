package pessoas;

public class Mulher extends Pessoa{

    public Mulher (double a, double p){
        super(a, p);
    }

    @Override
    public String toString() {
        if (this.imc() < 19.0){
            return "Abaixo do peso ideal";
        }
        if((this.imc() > 19.0) && (this.imc() < 25.8)){
            return "Peso ideal";
        }
        else{
            return "Acima do peso ideal";
        }
    }
}

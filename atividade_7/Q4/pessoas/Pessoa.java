package pessoas;

public class Pessoa {
    private double altura;
    private double peso;

    public Pessoa(double altura, double peso){
        this.altura = altura;
        this.peso = peso;
    }
    public double getAltura(){
        return altura;
    }
    public void setAltura(double altura){
        this.altura = altura;
    }

    public double getPeso(){
        return peso;
    }
    public void setPeso(){
        this.peso = peso;
    }

    public double imc(){
        double imc = this.peso/(this.altura*this.altura);

        return imc;
    }

}

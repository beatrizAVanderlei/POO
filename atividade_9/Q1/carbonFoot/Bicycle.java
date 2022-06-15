package carbonFoot;

public class Bicycle implements CarbonFootprint {
    private String modelo;
    private double preço;

    public Bicycle(String modelo, double preço){
        this.modelo = modelo;
        this.preço = preço;
    }

    public String getModelo(){
        return this.modelo;
    }

    public double getPreço(){
        return this.preço;
    }

    @Override
    public String getCarbonFootprint() {
        return "A bicicleta do modelo "+getModelo()+" não produz gás carbônico e custa "+getPreço()+" reais";
    }
}


package carbonFoot;

public class Car implements CarbonFootprint {
    private String modelo;
    private String tipoDeCombustivel;
    private double distanciaPercorrida;
    private double tempoGasto;
    private double quantidadeDeLitros;
    private double gasolinaPorKM;
    private double densidadeDaGasolina;
    private double fatorDeTransformacaoDaGasolina;
    private double carboonFoot;

    public Car(double tempoGasto, double distanciaPercorrida, String combustivel, String modelo, double litros, double percurso){
        this.tempoGasto = tempoGasto;
        this.distanciaPercorrida = distanciaPercorrida;
        this.modelo = modelo;
        this.tipoDeCombustivel = combustivel;
        this.gasolinaPorKM = percurso;
        this.quantidadeDeLitros = litros;
        this.densidadeDaGasolina = 0.75; //por litro;
        this.fatorDeTransformacaoDaGasolina = 3.7;
    }

    public String getTipoDeCombustivel(){
        return this.tipoDeCombustivel;
    }
    public void setTipoDeCombustivel(String combustivel){
        this.tipoDeCombustivel = combustivel;
    }

    public double getQuantidadeDeLitros(){
        return this.quantidadeDeLitros;
    }
    public void setQuantidadeDeLitros(double litros){
        this.quantidadeDeLitros = litros;
    }

    public double getGasolinaPorKM(){
        return this.gasolinaPorKM;
    }
    public void setGasolinaPorKM(double percurso){
        this.gasolinaPorKM = percurso;
    }

    public String getModelo(){
        return this.modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public double gasolinaGastaEmPercurso(){
        return this.quantidadeDeLitros/this.gasolinaPorKM;
    }

    public double velocidadeMedia(){
        return this.distanciaPercorrida/this.tempoGasto;
    }

    @Override
    public String getCarbonFootprint() {
        this.carboonFoot = (this.quantidadeDeLitros/this.gasolinaPorKM)*0.82*this.densidadeDaGasolina*this.densidadeDaGasolina;
        return "O modelo do carro é "+getModelo()+", o seu combustível é "+getTipoDeCombustivel()+" e emite "+this.carboonFoot+" de carbono";
    }
}
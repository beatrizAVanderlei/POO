package carbonFoot;

public class Building implements CarbonFootprint {
    private int quantidadeDeMoradores;
    private double tamanhoDaConstrucaoEmMetrosQuadrados;
    private double quantidadeDeCO2;
    private double quantidadeDeCH4;
    private double quantidadeDeNO2;
    private final int GWP100DoCO2;
    private final int GWP100DoCH4;
    private final int GWP100DoNO2;
    private double carbonFoot;

    public Building(double tamanhoDaConstrucaoEmMetrosQuadrados, int quantidadeDeMoradores, double quantidadeDeCO2, double quantidadeDeCH4, double quantidadeDeNO2){
        this.tamanhoDaConstrucaoEmMetrosQuadrados = tamanhoDaConstrucaoEmMetrosQuadrados;
        this.quantidadeDeMoradores = quantidadeDeMoradores;
        this.quantidadeDeCO2 = quantidadeDeCO2;
        this.quantidadeDeCH4 = quantidadeDeCH4;
        this.quantidadeDeNO2 = quantidadeDeNO2;
        this.GWP100DoCO2 = 1;
        this.GWP100DoCH4 = 28;
        this.GWP100DoNO2 = 265;
    }

    public double getQuantidadeDeCO2(){
        return this.quantidadeDeCO2;
    }
    public void setQuantidadeDeCO2(double quantidadeDeCO2){
        this.quantidadeDeCO2 = quantidadeDeCO2;
    }

    public double getQuantidadeDeCH4(){
        return this.quantidadeDeCH4;
    }
    public void setQuantidadeDeCH4(double quantidadeDeCH4){
        this.quantidadeDeCH4 = quantidadeDeCH4;
    }

    public double getQuantidadeDeNO2(){
        return this.quantidadeDeNO2;
    }
    public void setQuantidadeDeNO2(double quantidadeDeNO2){
        this.quantidadeDeNO2 = quantidadeDeNO2;
    }

    public int getQuantidadeDeMoradores(){
        return this.quantidadeDeMoradores;
    }
    public void setQuantidadeDeMoradores(int quantidadeDeMoradores){
        this.quantidadeDeMoradores = quantidadeDeMoradores;
    }

    public double getTamanhoDaConstrucaoEmMetrosQuadrados(){
        return this.tamanhoDaConstrucaoEmMetrosQuadrados;
    }
    public void setTamanhoDaConstrucaoEmMetrosQuadrados(double tamanhoDaConstrucaoEmMetrosQuadrados){
        this.tamanhoDaConstrucaoEmMetrosQuadrados = tamanhoDaConstrucaoEmMetrosQuadrados;
    }

    public double habitantesPorMetrosQuadrados(){
        return getQuantidadeDeMoradores()/getTamanhoDaConstrucaoEmMetrosQuadrados();
    }

    @Override
    public String getCarbonFootprint() {
        this.carbonFoot = (this.quantidadeDeCO2*this.GWP100DoCO2) + (this.quantidadeDeCH4*this.GWP100DoCH4) + (this.quantidadeDeNO2*this.GWP100DoNO2);
        return "Uma construção com "+getQuantidadeDeMoradores()+" emite "+this.carbonFoot+" de carbono";
    }
}


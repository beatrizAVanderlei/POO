package lampadas;

public class LampadaFluorescente extends Lampada{
    private double comprimentoDaLampada;

    public LampadaFluorescente(String m, boolean e, double comprimento){
        super(m, e);
        this.comprimentoDaLampada = comprimento;
    }

    @Override
    public String toString() {
        if(this.isEstadoDaLampada() == true){
            return "A lâmpada fluorescente está acesa";
        }
        else{
            return "A lâmpada fluorescente está apagada";
        }
    }
}

package lampadas;

public class Lampada {
    private String modeloLampada;
    private boolean estadoDaLampada;

    public Lampada(String modeloLampada, boolean estadoDaLampada) {
        this.modeloLampada = modeloLampada;
        this.estadoDaLampada = estadoDaLampada;
    }

    public String getModeloLampada() {
        return this.modeloLampada;
    }
    public void setModeloLampada(String modeloLampada) {
        this.modeloLampada = modeloLampada;
    }

    public boolean isEstadoDaLampada(){
        return this.estadoDaLampada;
    }
    public void setEstadoDaLampada(boolean estadoDaLampada){
        this.estadoDaLampada = estadoDaLampada;
    }

    public void acende(){
        this.estadoDaLampada = true;
    }
    public void apaga(){
        this.estadoDaLampada = false;
    }

    @Override
    public String toString() {
        if(this.estadoDaLampada == true){
            return "A lâmpada está acesa";
        }
        else{
            return "A lâmpada está apagada";
        }
    }
}

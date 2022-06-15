package lampada;
import java.util.ArrayList;
import java.util.Collections;

public class Lampada implements Comparable<Lampada>{
    private int watts;
    private String modeloLampada;
    private boolean estadoDaLampada;

    public Lampada(String modeloLampada, boolean estadoDaLampada, int watts) {
        this.modeloLampada = modeloLampada;
        this.estadoDaLampada = estadoDaLampada;
        this.watts = watts;
    }

    public int getWatts(){
        return this.watts;
    }
    public void setWatts(int watts){
        this.watts = watts;
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

    //ordenar de forma decrescente
    @Override
    public int compareTo(Lampada o) {
        if(this.getWatts() > o.getWatts())
            return -1;
        if(this.getWatts() < o.getWatts())
            return 1;
        return 0;
    }
}


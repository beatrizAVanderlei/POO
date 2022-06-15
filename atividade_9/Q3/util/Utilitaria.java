package util;
import java.util.ArrayList;
import employee.*;

public class Utilitaria {

    public static double media(ArrayList<Measurable> lista){
        double soma = 0;
        for(Measurable m : lista){
            soma = soma+m.getMeasure();
        }
        return soma/ lista.size();
    }
}

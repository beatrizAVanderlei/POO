package testeLampada;
import lampada.*;
import java.util.ArrayList;
import java.util.Collections;
public class Teste {
    public static void main(String[] args) {
        ArrayList<Lampada> lampadas = new ArrayList<>();
        Lampada l1 = new Lampada("aaaaaaaaa", true, 250);
        Lampada l2 = new Lampada("bbbbbbbb", true, 570);
        Lampada l3 = new Lampada("ccccccccccc", true, 250);

        lampadas.add(l1);
        lampadas.add(l2);
        lampadas.add(l3);

        Collections.sort(lampadas);

        for(Lampada l : lampadas){
            System.out.println("A lampada do modelo "+l.getModeloLampada()+" tem "+l.getWatts()+" watts");
        }
    }
}

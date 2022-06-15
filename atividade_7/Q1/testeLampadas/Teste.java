package testeLampadas;
import lampadas.*;

public class Teste {
    public static void main(String[] args) {
        Lampada l1 = new Lampada("modelo", true);
        l1.apaga();
        System.out.println(l1.toString());
        LampadaFluorescente l2 = new LampadaFluorescente(l1.getModeloLampada(), false, 25.7);
        l2.acende();
        System.out.println(l2.toString()); //uso do comportamento polimorfico, onde a subclasse LampadaFluorescente possuí seu próŕio método toString, sendo diferenciados pelo tipo do parâmetro

    }
}

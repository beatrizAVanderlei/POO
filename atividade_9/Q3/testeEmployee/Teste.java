package testeEmployee;
import util.*;
import employee.*;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<Measurable> lista = new ArrayList<>();
        BasePlusCommissionEmployee a = new BasePlusCommissionEmployee("ze", "silva", "3445-0", 10, 0.5, 100);
        CommissionEmployee b = new CommissionEmployee("ana", "silva", "1134-6", 10, 0.5);

        lista.add(a);
        lista.add(b);

        System.out.println(Utilitaria.media(lista));
        System.out.println(a.earnings());
        System.out.println(b.earnings());
    }
}

package teste;
import carbonFoot.*;
import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<CarbonFootprint> lista = new ArrayList<CarbonFootprint>();

        Car c = new Car(4.0, 2000, "gasolina", "fusca", 50, 10);
        lista.add(c);
        Bicycle b = new Bicycle("1980", 750.00);
        lista.add(b);
        Building construction = new Building(100, 100, 1000.00, 10.0, 0.1);
        lista.add(construction);

        for(CarbonFootprint l : lista){
            System.out.println(l.getCarbonFootprint());
        }

    }
}

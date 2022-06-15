package teste;
import retangulo.Retangulo;
public class Teste {
    public static void main(String[] args) {
        Retangulo r = new Retangulo();
        double perimetro;
        double area;

        r.setAltura(10.0);
        r.setLargura(15.0);

        area = r.area();
        perimetro = r.perimetro();

        System.out.println("O perímetro do retângulo é: "+perimetro);
        System.out.println("A área do retângulo é: "+area);
    }
}

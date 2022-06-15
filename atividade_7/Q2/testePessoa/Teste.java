package testePessoa;
import pessoas.*;

public class Teste {
    public static void main(String[] args) {
        Homem homem = new Homem(2.10, 67.5);
        Mulher mulher = new Mulher (1.55, 68.0);

        System.out.println(mulher.toString());
        System.out.println(homem.toString());
    }
}

import java.util.Random;
public class BancoDePalavras {
    public static void main(String[] args) {
        String[] vetorDePalavras = new String[]{"azul", "verde", "dinossauro", "josué", "ana"};
        String palavra;

        palavra = sorteio(vetorDePalavras);

        System.out.println("A palavra sorteada é: "+ palavra);
    }

    public static String sorteio(String[] v){
        Random r = new Random();
        int i = r.nextInt(v.length);
        String palavra = v[i];

        return palavra;
    }

}

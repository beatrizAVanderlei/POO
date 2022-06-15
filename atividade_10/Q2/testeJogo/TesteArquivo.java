package testeJogo;
import palavras.BancoDePalavras;
import java.io.IOException;

public class TesteArquivo {
    public static void main(String[] args) {
        try{
            BancoDePalavras a = new BancoDePalavras(4, "vetorA.dat");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
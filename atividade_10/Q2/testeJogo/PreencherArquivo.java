package testeJogo;
import excecoesPalavra.IndiceInvalidoException;
import excecoesPalavra.PalavraInvalidaException;
import palavras.BancoDePalavras;

import java.io.IOException;

public class PreencherArquivo {
    public static void main(String[] args) {
        BancoDePalavras a = new BancoDePalavras(4);
        try {
            a.adicionarPalavras("jubiscreia");
            a.adicionarPalavras("monica");
            a.adicionarPalavras("joaninha");
            a.adicionarPalavras("jujuba");
        } catch (PalavraInvalidaException e) {
            System.out.println(e.getMessage());
        } catch (IndiceInvalidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            a.salvarVetor("vetorA.dat");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


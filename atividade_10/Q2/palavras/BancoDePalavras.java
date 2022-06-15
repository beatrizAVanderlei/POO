package palavras;
import java.util.Random;
import java.io.*;
import excecoesPalavra.*;

public class BancoDePalavras implements Serializable {
    private String[] vetor;
    private int tamanho;
    private int indice;

    public BancoDePalavras(int i) {
        this.tamanho = i;
        this.vetor = new String[this.tamanho];
        this.indice = 0;

    }

    public BancoDePalavras(int i, String nomeArquivo) throws IOException, ClassNotFoundException {
        this(i);
        FileInputStream arquivo = new FileInputStream(nomeArquivo);
        ObjectInputStream inputStream = new ObjectInputStream(arquivo);
        this.vetor = (String[]) inputStream.readObject();
        this.indice = (int) inputStream.readObject();
        inputStream.close();

    }

    public String[] getVetor(){
        return this.vetor;
    }
    public int getIndice(){
        return this.indice;
    }

    public void adicionarPalavras(String palavra) throws IndiceInvalidoException, PalavraInvalidaException{
        if(palavra.length() < 1)
            throw new PalavraInvalidaException();
        else{
            if(this.indice > this.tamanho)
                throw new IndiceInvalidoException();
            else {
                this.vetor[indice] = palavra;
                this.indice++;
            }
        }
    }

    public String sortearPalavra(){
        Random r = new Random();
        int i = r.nextInt(this.indice);

        return this.vetor[i];
    }

    public void salvarVetor(String nomeArquivo) throws IOException {
        FileOutputStream arquivo = new FileOutputStream(nomeArquivo);
        ObjectOutputStream outputStream = new ObjectOutputStream(arquivo);
        outputStream.writeObject(this.vetor);
        outputStream.writeObject(this.indice);
        outputStream.close();
    }
}

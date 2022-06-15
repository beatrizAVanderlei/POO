package palavras;
import excecoesPalavra.CaracterInvalidoException;
import excecoesPalavra.FimDoJogoException;
import excecoesPalavra.LetrasJogadasException;

import java.util.ArrayList;

public class JogoDaForca {
    private BancoDePalavras vetor;
    private int contadorErros;
    private char[] palavra;
    private char[] segundaPalavra;
    private ArrayList<Character> letrasJogadas;

    public JogoDaForca(BancoDePalavras vetor){
        this.vetor = vetor;
        this.iniciarPartida();
    }

    public void iniciarPartida(){
        this.letrasJogadas = new ArrayList<Character>();
        this.palavra = this.vetor.sortearPalavra().toUpperCase().toCharArray();
        this.segundaPalavra = new char[this.palavra.length];
        for(int i = 0; i < this.segundaPalavra.length; i++){
            this.segundaPalavra[i] = '_';
        }
        this.contadorErros = 0;
    }

    public boolean jogada(char letra) throws LetrasJogadasException, FimDoJogoException, CaracterInvalidoException {
        letra = Character.toUpperCase(letra);
        boolean existeLetra = false;
        if(Character.getType(letra) != Character.UPPERCASE_LETTER){
            throw new CaracterInvalidoException();
        }
            if (!letrasJogadas.contains(letra)) {

                this.letrasJogadas.add(letra);

                for (int i = 0; i < this.palavra.length; i++) {
                    if (letra == this.palavra[i]) {
                        this.segundaPalavra[i] = letra;
                        existeLetra = true;
                    }
                }
                if (!existeLetra) {
                    this.contadorErros++;
                    if (6 <= this.contadorErros) {
                        throw new FimDoJogoException();
                    }
                } else {
                    return ganhou();
                }
            } else {
                throw new LetrasJogadasException(letra);
            }

        return false;
    }

    public boolean ganhou(){
        String s1 = new String(this.palavra);
        String s2 = new String(this.segundaPalavra);
        return (s1.equals(s2));
    }

    public void imprimirForca(){
        System.out.println();
        for(int i = 0; i < this.segundaPalavra.length; i++){
            System.out.print(this.segundaPalavra[i]+ " ");
        }
        System.out.println();
        System.out.println("ERROS: "+this.contadorErros);
    }

}

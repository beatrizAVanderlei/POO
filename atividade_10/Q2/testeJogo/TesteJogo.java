package testeJogo;
import excecoesPalavra.CaracterInvalidoException;
import excecoesPalavra.FimDoJogoException;
import excecoesPalavra.LetrasJogadasException;
import palavras.*;
import java.util.Scanner;
import java.io.IOException;

public class TesteJogo {
    public static void main(String[] args) {
        try {
            BancoDePalavras palavrasDoJogo = new BancoDePalavras(4, "vetorA.dat");
            JogoDaForca jogo = new JogoDaForca(palavrasDoJogo);
            Scanner entrada = new Scanner(System.in);
            char jogarNovamente;
            do {
                boolean fimJogo = false;
                while(true) {
                    jogo.imprimirForca();
                    System.out.print("Digite uma letra: ");
                    char letra = entrada.nextLine().charAt(0);
                    try {
                        if(jogo.jogada(letra)) {
                            System.out.println("Você ganhou :)");
                            fimJogo = true;
                        }
                    } catch (LetrasJogadasException e) {
                        System.out.println(e.getMessage());
                    } catch (FimDoJogoException e) {
                        System.out.println(e.getMessage());
                        fimJogo = true;
                    } catch (CaracterInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    if(fimJogo)
                        break;
                }
                jogo.imprimirForca();
                System.out.println("Digite 's' para jogar novamente");
                jogarNovamente = entrada.nextLine().charAt(0);
                jogarNovamente = Character.toUpperCase(jogarNovamente);
                jogo.iniciarPartida();
            } while(jogarNovamente == 'S');

        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}

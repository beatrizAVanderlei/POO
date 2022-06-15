import java.util.Random;
public class JogoDeCraps {
    public static void main(String[] args) {
        Random r = new Random();
        int dado1;
        int dado2;
        int soma;
        int ponto;
        int rodada;
        boolean ganhou;

        ganhou= false;
        rodada = 1;
        ponto = 0;

        while(true) {

            dado1 = r.nextInt(6);
            dado2 = r.nextInt(6);
            dado1 = dado1 + 1;
            dado2 = dado2 + 1;
            soma = dado1 + dado2;

            if(rodada == 1) {
                if ((soma == 7) || (soma == 11)) {
                    ganhou = true;
                    break;
                }
                if ((soma == 2) || (soma == 3) || (soma == 12)) {
                    ganhou = false;
                    break;
                }

                ponto = soma;

            } else {
                if (soma == 7){
                    ganhou = false;
                    break;
                }
                if (ponto == soma){
                    ganhou = true;
                    break;
                }
            }

            rodada ++;

        }

        if (ganhou == true){
            System.out.println("Parabéns, você ganhou o jogo :)");
        }

        if (ganhou == false){
            System.out.println("Você perdeu :(");
        }
    }
}

package testeFilmes;
import filmes.*;

public class Teste {
    public static void main(String[] args) {
        Infantil i = new Infantil("Jovens titãs em ação");
        Lancamento l = new Lancamento("Soul");
        Promocao p = new Promocao("Aves de Rapina");

        System.out.println("O preço do filme "+i.getNome()+" é "+i.getPrecoDaLocacao());
        System.out.println("O preço do filme "+l.getNome()+" é "+l.getPrecoDaLocacao());
        System.out.println("O preço do filme "+p.getNome()+" é "+p.getPrecoDaLocacao());
    }
}

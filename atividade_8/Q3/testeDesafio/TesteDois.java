package testeDesafio;
import desafio.*;

public class TesteDois {
    public static void main(String[] args) {
        Categoria lancamento = new Categoria("lançamento", 3.00);
        Categoria promocao = new Categoria("promoção", -2.00);

        Infantil i = new Infantil("Tigrão - O filme");
        i.adicionarCategoria(promocao);

        System.out.println("O filme "+i.getNome()+" tem o preço de locação de "+i.getPrecoDaLocacao());

        Infantil a = new Infantil("Your name");
        a.adicionarCategoria(lancamento);

        System.out.println("O filme "+a.getNome()+" tem o preço de locação de "+a.getPrecoDaLocacao());
    }

    //Este modelo de teste trabalha com os conceitos de herança e associação de classes, sendo um código mais organizado, porém, mais limitado, já que todos os gêneros terão de ter sua própria classe
}

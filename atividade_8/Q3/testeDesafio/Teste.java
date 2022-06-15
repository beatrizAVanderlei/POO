package testeDesafio;
import desafio.*;

public class Teste {
    public static void main(String[] args) {
        Categoria infantil = new Categoria("infantil", 2.00);
        Categoria lancamento = new Categoria("lancamento", 3.00);
        Categoria promocao = new Categoria("promocao", -2.00);

        Filme f1 = new Filme("Procurando nemo");
        f1.adicionarCategoria(infantil);

        System.out.println("O preço do filme "+ f1.getNome()+" é "+f1.getPrecoDaLocacao());

        Filme f2 = new Filme("Soul");
        f2.adicionarCategoria(infantil);
        f2.adicionarCategoria(lancamento);

        System.out.println("O preço da locacao do filme "+f2.getNome()+" é "+f2.getPrecoDaLocacao());

        //Essa solução permite maior flexibilidade e criação de novas categorias, incluindo novas combinações, já que não possuí um número fixo, porém, o código em um geral fica menos organizado.
    }
}

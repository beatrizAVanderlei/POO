package teste;
import contas.*;
public class Teste {
    public static void main(String[] args) {
        ClientePessoaJuridica c = new ClientePessoaJuridica("5559-7", 780, "74.500.9");
        ClientePessoaFisica b = new ClientePessoaFisica("47590-5", 900, "765-99-23");

        RepositorioContas repositorio = new RepositorioContas();

        repositorio.adiconarConta(c);

        repositorio.recuperarConta(c);
        repositorio.recuperarConta(b);
    }
}

package negocio.regras;
import excecoes.ContaJaAdicionadaException;
import excecoes.ContaNaoExisteException;
import negocio.entidades.Cliente;
import negocio.entidades.Conta;
import dados.repositórios.IRepositorioDeContas;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta classe trata as regras de negócio relacionadas a classe Conta.
 * Esta classe pode lançar as seguintes exceções: IOException, FileNotFoundException, ClassNotFoundException,
 * ContaJaAdicionadaException e ContaNaoExisteException.
 *
 * @author Ana Beatriz Almeida
 */

public class NegocioContas {
    private IRepositorioDeContas repositorio;

    public NegocioContas(IRepositorioDeContas repositorioDeContas){
        this.repositorio = repositorioDeContas;
    }

    public void adicionar(Conta conta) throws ContaJaAdicionadaException, IOException {
        if(!this.repositorio.existe(conta))
            this.repositorio.adicionarConta(conta);
        else
            throw new ContaJaAdicionadaException(conta);
    }

    public void atualizar(Conta conta, Conta contaAtualizada) throws ContaNaoExisteException, IOException {
        if(this.repositorio.existe(conta))
            this.repositorio.atualizarConta(conta, contaAtualizada);
        else
            throw new ContaNaoExisteException();
    }

    public ArrayList<Conta> recuperar(){
        return this.repositorio.recuperar();
    }

    public void remover(Conta conta) throws ContaNaoExisteException, IOException {
        if(this.repositorio.existe(conta))
            this.repositorio.removerConta(conta);
        else
            throw new ContaNaoExisteException();
    }

    public Conta consultarConta(String CPF) throws ContaNaoExisteException{
        Conta conta1 = this.repositorio.consultarConta(CPF);

        if(conta1 == null)
            throw new ContaNaoExisteException();
        else
            return conta1;
    }
}

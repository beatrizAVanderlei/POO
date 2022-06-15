package negocio.fachada;

import dados.repositórios.*;
import excecoes.*;
import negocio.entidades.*;
import negocio.regras.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta classe é responsável por conter todos os métodos relacionado ao uso do sistema pelo funcionário.
 * Esta classe pode lançar as seguintes exceções: PaisNaoExisteException, CidadeNaoExisteException e
 * IdiomaNaoEncontradoException, QuantidadeDeMesesInvalidaException, ReservaInvalidaException, IOException,
 * ContaJaAdicionadaException, ContaNaoExisteException, CPFInvalidoException, NomeInvalidoException,
 * IdadeInvalidaException, GeneroInvalidoException, ClienteJaAdicionadoException, ClienteNaoExisteException.
 *
 * @author Gabriel Viana e Ana Beatriz
 */
public class FachadaFuncionario {

    private final NegocioPais paises;
    private final NegocioCidade cidades;
    private final NegocioHospedagem hospedagens;
    private final NegocioEscolas escolas;
    private final NegocioContas contas;
    private final NegocioClientes clientes;
    private final static String USUARIO = "func";
    private final static String SENHA = "func";

    public FachadaFuncionario() {
        this.paises = new NegocioPais(new RepositorioDePaises());
        this.cidades = new NegocioCidade(new RepositorioDeCidades());
        this.hospedagens = new NegocioHospedagem(new RepositorioDeHospedagens());
        this.contas = new NegocioContas(new RepositorioDeContas());
        this.escolas = new NegocioEscolas(new RepositorioDeEscolas());
        this.clientes = new NegocioClientes(new RepositorioDeClientes());
    }

    public static String getUSUARIO() {
        return USUARIO;
    }

    public static String getSENHA() {
        return SENHA;
    }

    public ArrayList<String> consultarIdiomaDosPaises() {
        return this.paises.consultarIdiomaDosPaises();
    }

    public ArrayList<Pais> procurarPaisPeloIdioma(String idioma) throws IdiomaNaoEncontradoException {
        return this.paises.procurarPaisPeloIdioma(idioma);
    }

    public ArrayList<Cidade> procurarCidadesPeloPais(Pais pais) throws PaisNaoExisteException {
        return this.cidades.procurarCidadesPeloPais(pais);
    }

    public ArrayList<Hospedagem> procurarHospedagensPelaCidade(Cidade cidade) throws CidadeNaoExisteException {
        return this.hospedagens.procurarHospedagensPelaCidade(cidade);
    }

    public void adicionarConta(Cidade cidade, Hospedagem hospedagem, Cliente cliente, Escolas escola, double reserva, double meses) throws QuantidadeDeMesesInvalidaException, ReservaInvalidaException, IOException, ContaJaAdicionadaException {
        Conta conta = new Conta(cidade, hospedagem, cliente, escola, reserva, meses);
        this.contas.adicionar(conta);
    }

    public void atualizarConta(Cidade cidade, Conta conta, Hospedagem hospedagem, Cliente cliente, Escolas escola, double reserva, double meses) throws QuantidadeDeMesesInvalidaException, ReservaInvalidaException, IOException, ContaNaoExisteException {
        Conta conta1 = new Conta(cidade, hospedagem, cliente, escola, reserva, meses);
        this.contas.atualizar(conta, conta1);
    }

    public void removerConta(Conta conta) throws ContaNaoExisteException, IOException {
        this.contas.remover(conta);
    }

    public ArrayList<Conta> consultarTodasAsContas(){
        return this.contas.recuperar();
    }

    public Conta consultarConta(String CPF) throws ContaNaoExisteException{
        return this.contas.consultarConta(CPF);
    }

    public void adicionarCliente(String nome, String sobrenome, String CPF, int idade, char genero) throws CPFInvalidoException, NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, IOException, ClienteJaAdicionadoException {
        Cliente cliente = new Cliente(sobrenome, nome, CPF, idade, genero);
        this.clientes.adicionar(cliente);
    }

    public void atualizarCliente(Cliente cliente, String sobrenomeAtualizado, String nomeAtualizado, String CPF, int idadeAtualizada, char generoAtualizado) throws CPFInvalidoException, NomeInvalidoException, IdadeInvalidaException, GeneroInvalidoException, IOException, ClienteNaoExisteException {
        Cliente cliente1 = new Cliente(sobrenomeAtualizado, nomeAtualizado, CPF, idadeAtualizada, generoAtualizado);
        this.clientes.atualizar(cliente, cliente1);
    }

    public void removerCliente(Cliente cliente) throws ClienteNaoExisteException, IOException {
        this.clientes.remover(cliente);
    }

    public ArrayList<Cliente> consultarTodosOsClientes(){
        return this.clientes.recuperar();
    }

    public Cliente consultarCliente(String CPF) throws ClienteNaoExisteException {
        return this.clientes.consultarCliente(CPF);
    }

    public ArrayList<Escolas> procurarEscolaPelaCidade(String cidade) throws CidadeNaoExisteException {
        return this.escolas.procurarEscolaPelaCidade(cidade);
    }

    public void gerarBoleto(Conta conta) {
        ICustos.gerarBoleto(conta);
    }

    public Pais consultarPais(String nome) throws PaisNaoExisteException {
        return this.paises.consultarPais(nome);
    }

    public Cidade consultarCidade(String nome) throws CidadeNaoExisteException {
        return this.cidades.consultarCidade(nome);
    }

    public Escolas consultarEscola(String nome) throws EscolaNaoExisteException {
        return this.escolas.consultarEscola(nome);
    }

    public Hospedagem consultarHospedagem(String id) throws HospedagemNaoExisteException {
        return this.hospedagens.consultarHospedagem(id);
    }

}

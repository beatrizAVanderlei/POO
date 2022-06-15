package negocio.fachada;

import dados.repositórios.*;
import excecoes.*;
import negocio.entidades.*;
import negocio.regras.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Esta classe é responsável por conter todos os métodos relacionado ao gerenciamento do sistema.
 * Esta classe pode lançar as seguintes exceções: IOException, PrecoDaPassagemInvalidoException, PaisJaAdicionadoException,
 * PaisNaoExisteException, CidadeJaAdicionadaException, CidadeNaoExisteException, HospedagemJaAdicionadaException e
 * HospedagemNaoExisteException, ClienteJaAdicionadoException, ClienteNaoExisteException, NomeInvalidoException,
 * IdadeInvalidaException, GeneroInvalidoException, CPFInvalidoException, QuantidadeDeMesesInvalidaException,
 * ReservaInvalidaException, MensalidadeInvalidaException, EmailInvalidoException, EnderecoInvalidoException,
 * NomeInvalidoException, QuantidadeDeAlunosInvalidaException
 *
 * @author Gabriel Viana e Ana Beatriz
 */
public class FachadaAdministrador {

    private final NegocioPais paises;
    private final NegocioCidade cidades;
    private final NegocioHospedagem hospedagens;
    private final NegocioEscolas escolas;
    private final NegocioContas contas;
    private final NegocioClientes clientes;
    private final static String USUARIO = "admin";
    private final static String SENHA = "admin";

    public FachadaAdministrador() {
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

    public void adicionarPais(String nome, String idioma, double precoDaPassagem) throws PrecoDaPassagemInvalidoException, PaisJaAdicionadoException, IOException {
        Pais pais = new Pais(nome, idioma, precoDaPassagem);
        this.paises.adicionar(pais);
    }

    public void atualizarPais(String nome, String nomeAtualizado, String idiomaAtualizado, double precoDaPassagemAtualizado) throws PaisNaoExisteException, PrecoDaPassagemInvalidoException, IOException {
        Pais pais = this.paises.consultarPais(nome);
        Pais paisAtualizado = new Pais(nomeAtualizado, idiomaAtualizado, precoDaPassagemAtualizado);
        this.paises.atualizar(pais, paisAtualizado);
    }

    public void removerPais(String nome) throws PaisNaoExisteException, IOException {
        Pais pais = this.paises.consultarPais(nome);
        this.paises.remover(pais);
    }

    public ArrayList<Pais> consultarTodosPaises() {
        return this.paises.recuperar();
    }

    public Pais consultarPais(String nome) throws PaisNaoExisteException {
        return this.paises.consultarPais(nome);
    }

    public void adicionarCidade(String nomeDaCidade, String nomeDoPais) throws PaisNaoExisteException, IOException, CidadeJaAdicionadaException {
        Pais pais = this.paises.consultarPais(nomeDoPais);
        Cidade cidade = new Cidade(pais, nomeDaCidade);
        this.cidades.adcionar(cidade);
    }

    public void atualizarCidade(String nomeDaCidade, String nomeDaCidadeAtualizada, String nomeDoPaisAtualizado) throws CidadeNaoExisteException, PaisNaoExisteException, IOException {
        Cidade cidade = this.cidades.consultarCidade(nomeDaCidade);
        Pais pais = this.paises.consultarPais(nomeDoPaisAtualizado);
        Cidade cidadeAtualizada = new Cidade(pais, nomeDaCidadeAtualizada);
        this.cidades.atualizar(cidade, cidadeAtualizada);
    }

    public void removerCidade(String nome) throws CidadeNaoExisteException, IOException {
        Cidade cidade = this.cidades.consultarCidade(nome);
        this.cidades.remover(cidade);
    }

    public ArrayList<Cidade> consultarTodasCidades() {
        return this.cidades.recuperar();
    }

    public Cidade consultarCidade(String nome) throws CidadeNaoExisteException {
        return this.cidades.consultarCidade(nome);
    }

    public void adicionarHospedagem(Hospedagem hospedagem) throws HospedagemJaAdicionadaException, IOException {
        this.hospedagens.adicionar(hospedagem);
    }

    public void atualizarHospedagem(String id, Hospedagem hospedagemAtualizada) throws HospedagemNaoExisteException, IOException {
        Hospedagem hospedagem = this.hospedagens.consultarHospedagem(id);
        this.hospedagens.atualizar(hospedagem, hospedagemAtualizada);
    }

    public void removerHospedagem(String id) throws HospedagemNaoExisteException, IOException {
        Hospedagem hospedagem = this.hospedagens.consultarHospedagem(id);
        this.hospedagens.remover(hospedagem);
    }

    public ArrayList<Hospedagem> consultarTodasHospedagens() {
        return this.hospedagens.recuperar();
    }

    public Hospedagem consultarHospedagem(String id) throws HospedagemNaoExisteException {
        return this.hospedagens.consultarHospedagem(id);
    }

    public void adicionarEscola(Cidade cidade, String email, String endereco, String nome, int alunos, double mensalidade) throws MensalidadeInvalidaException, EmailInvalidoException, EnderecoInvalidoException, NomeInvalidoException, QuantidadeDeAlunosInvalidaException, IOException, EscolaJaAdicionadaException {
        Escolas escola = new Escolas(cidade, email, endereco, nome, alunos, mensalidade);
        this.escolas.adicionar(escola);
    }

    public void atualizarEscola(Escolas escola, Cidade cidade, String email, String endereco, String nome, int alunos, double mensalidade) throws MensalidadeInvalidaException, EmailInvalidoException, EnderecoInvalidoException, NomeInvalidoException, QuantidadeDeAlunosInvalidaException, IOException, EscolaNaoExisteException {
        Escolas escolas1 = new Escolas(cidade, email, endereco, nome, alunos, mensalidade);
        this.escolas.atualizar(escola, escolas1);
    }

    public void removerEscola(Escolas escola) throws IOException, EscolaNaoExisteException {
        this.escolas.remover(escola);
    }

    public ArrayList<Escolas> consultarTodasAsEscolas(){
        return this.escolas.recuperar();
    }

    public Escolas consultarEscola(String nome) throws EscolaNaoExisteException {
        return this.escolas.consultarEscola(nome);
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

    public ArrayList<Cliente> consultarTodosOsClientes(){ return this.clientes.recuperar(); }

    public Cliente consultarCliente(String CPF) throws ClienteNaoExisteException {
        return this.clientes.consultarCliente(CPF);
    }
}

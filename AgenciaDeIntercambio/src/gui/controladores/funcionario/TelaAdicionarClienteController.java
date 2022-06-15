package gui.controladores.funcionario;
import excecoes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.fachada.FachadaFuncionario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * A classe controladora TelaAdicionarClienteController vai receber dados da tela TelaAdicionarCliente,
 * primeiroNome(String), segundoNome(String), idade(int), genero(char) e CPF(String), então, vai adicionar
 * um novo cliente ao arquivo do repositório.
 *
 * @author Ana Beatriz Almeida.
 */

public class TelaAdicionarClienteController implements Initializable {
    @FXML
    private Label labelErro;
    @FXML
    private TextField textFieldPrimeiroNome;
    @FXML
    private TextField textFieldSegundoNome;
    @FXML
    private TextField textFieldIdade;
    @FXML
    private TextField textFieldGenero;
    @FXML
    private TextField textFieldCPF;

    private Stage stage;
    private FachadaFuncionario fachadaFuncionario;

    public TelaAdicionarClienteController(){
        this.fachadaFuncionario = new FachadaFuncionario();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/funcionario/TelaInicialFuncionario.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaInicialFuncionarioController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvar(ActionEvent event){
        String nome;
        String sobrenome;
        String cpf;
        int id;
        char gen;

        try{
            nome = textFieldPrimeiroNome.getText();
            sobrenome = textFieldSegundoNome.getText();
            cpf = textFieldCPF.getText();
            id = Integer.parseInt(textFieldIdade.getText());
            gen = textFieldGenero.getText().charAt(0);
            fachadaFuncionario.adicionarCliente(nome, sobrenome, cpf, id, gen);
            labelErro.setText("Cliente adicionado com sucesso");
        } catch(NumberFormatException nfe) {
            labelErro.setText("Digite apenas número em idade");
        } catch (IOException e) {
            labelErro.setText("Erro na gravação do arquivo");
        } catch (IdadeInvalidaException e) {
            labelErro.setText("Idade selecionada é inválida");
        } catch (GeneroInvalidoException e) {
            labelErro.setText("O genero selecionado é inválido");
        } catch (CPFInvalidoException e) {
            labelErro.setText("O CPF é inválido");
        } catch (ClienteJaAdicionadoException e) {
            labelErro.setText("O cliente já foi adicionado");
        } catch (NomeInvalidoException e) {
            labelErro.setText("O nome é inválido");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

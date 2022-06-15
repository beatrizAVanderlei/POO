package gui.controladores.administrador;
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
import negocio.fachada.FachadaAdministrador;
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
    private TextField textFieldSobrenome;
    @FXML
    private TextField textFieldIdade;
    @FXML
    private TextField textFieldGenero;
    @FXML
    private TextField textFieldCPF;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAdicionarClienteController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarClientes.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarClientesController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void salvar(ActionEvent event){
        String nome;
        String sobrenome;
        String cpf;
        int id;
        char gen;

        try{
            nome = textFieldPrimeiroNome.getText();
            sobrenome = textFieldSobrenome.getText();
            cpf = textFieldCPF.getText();
            id = Integer.parseInt(textFieldIdade.getText());
            gen = textFieldGenero.getText().charAt(0);
            fachadaAdministrador.adicionarCliente(nome, sobrenome, cpf, id, gen);
            labelErro.setText("Cliente adicionado com sucesso");
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

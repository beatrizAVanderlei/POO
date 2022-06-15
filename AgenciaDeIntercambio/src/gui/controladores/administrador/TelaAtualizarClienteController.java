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
import negocio.entidades.Cliente;
import negocio.fachada.FachadaAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAtualizarClienteController implements Initializable {
    @FXML
    private TextField textFieldCPFAntigo;
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldSobrenome;
    @FXML
    private TextField textFieldIdade;
    @FXML
    private TextField textFieldCPF;
    @FXML
    private TextField textFieldGenero;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAtualizarClienteController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
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

    public void salvar(ActionEvent actionEvent){
        String CPFAntigo;
        String nome;
        String sobrenome;
        String CPF;
        int idade;
        char genero;

        try{
            CPFAntigo = textFieldCPFAntigo.getText();
            nome = textFieldNome.getText();
            sobrenome = textFieldSobrenome.getText();
            CPF = textFieldCPF.getText();
            idade = Integer.parseInt(textFieldIdade.getText());
            genero = textFieldGenero.getText().charAt(0);
            Cliente c1 = fachadaAdministrador.consultarCliente(CPFAntigo);
            fachadaAdministrador.atualizarCliente(c1, nome, sobrenome, CPF, idade, genero);
            labelErro.setText("Cliente atualizado com sucesso");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar o arquivo");
        } catch (ClienteNaoExisteException e) {
            labelErro.setText("O cliente selecionado para ser atualizado não existe");
        } catch (IdadeInvalidaException e) {
            labelErro.setText("A idade selecionada é inválida");
        } catch (GeneroInvalidoException e) {
            labelErro.setText("O genero selecionado é inválido");
        } catch (CPFInvalidoException e) {
            labelErro.setText("O CPF selecionado é inválido");
        } catch (NomeInvalidoException e) {
            labelErro.setText("O nome selecionado é inválido");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

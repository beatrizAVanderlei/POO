package gui.controladores.funcionario;

import excecoes.ClienteNaoExisteException;
import excecoes.ContaNaoExisteException;
import excecoes.EscolaVaziaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.entidades.Conta;
import negocio.fachada.FachadaFuncionario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador da tela desmatricular cliente, onde recebe um CPF e desmatricula o cliente.
 *
 * @author Gabriel Viana e Ana Beatriz
 */
public class TelaDesmatricularClienteController implements Initializable {

    @FXML
    private TextField textFieldCpfCliente;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaFuncionario fachadaFuncionario;

    public TelaDesmatricularClienteController() {
        this.fachadaFuncionario = new FachadaFuncionario();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void desmatricularCliente(ActionEvent event) {
        String cpfCliente = textFieldCpfCliente.getText();
        try {
            if (cpfCliente.length() == 11) {
                Conta conta = fachadaFuncionario.consultarConta(cpfCliente);
                conta.getEscola().removerAluno();
                // comportamento polimórfico chamando o método removerPessoa()
                conta.getHospedagem().removerPessoa();
                this.fachadaFuncionario.removerCliente(conta.getCliente());
                this.fachadaFuncionario.removerConta(conta);
                labelErro.setText("Cliente desmatriculado com sucesso!");

            } else {
                labelErro.setText("CPF inválido!");
            }

        } catch (ContaNaoExisteException cnee) {
            labelErro.setText("Esse cliente não possui um planejamento de intercâmbio!");
        } catch (EscolaVaziaException eve) {
            labelErro.setText("Erro na desmatriculação!");
        } catch (ClienteNaoExisteException cnee) {
            labelErro.setText("O cliente a ser desmatriculado não está no repositório!");
        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

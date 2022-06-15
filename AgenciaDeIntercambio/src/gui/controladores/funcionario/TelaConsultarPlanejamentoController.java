package gui.controladores.funcionario;
import excecoes.ContaNaoExisteException;
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
 * A classe controladora TelaConsultarPlanejamentoController vai receber o CPF de um cliente(String),
 * na TelaConsultarPlanejamentoController e irá retornar a idade, o nome, a reserva financeira, a
 * quantidade de meses, a cidade, a hospedagem, o colégio, o país, o idioma e os custos totais a
 * qual o cliente está vinculado.
 *
 * @author Ana Beatriz Almeida.
 */

public class TelaConsultarPlanejamentoController implements Initializable {
    @FXML
    private TextField textFieldCpfCliente;
    @FXML
    private Label labelIdadeCliente;
    @FXML
    private Label labelEscolaCliente;
    @FXML
    private Label labelReservaCliente;
    @FXML
    private Label labelTempoCliente;
    @FXML
    private Label labelCidadeCliente;
    @FXML
    private Label labelHospedagemCliente;
    @FXML
    private Label labelNomeCliente;
    @FXML
    private Label labelPaisCliente;
    @FXML
    private Label labelIdiomaCliente;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaFuncionario fachadaFuncionario;

    public TelaConsultarPlanejamentoController(){
        this.fachadaFuncionario = new FachadaFuncionario();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    public void consultarPlanejamento(ActionEvent event) {
        try {
            Conta conta = fachadaFuncionario.consultarConta(textFieldCpfCliente.getText());
            labelEscolaCliente.setText(conta.getEscola().getNome());
            labelIdadeCliente.setText(String.valueOf(conta.getCliente().getIdade()));
            labelNomeCliente.setText(conta.getCliente().getNomeCompleto());
            labelReservaCliente.setText(String.valueOf(conta.getReservaEmergencia()));
            labelTempoCliente.setText(String.valueOf(conta.getQuantidadeMeses()));
            labelHospedagemCliente.setText(conta.getHospedagem().getId());
            labelCidadeCliente.setText(conta.getCidade().getNome());
            labelPaisCliente.setText(conta.getCidade().getPais().getNome());
            labelIdiomaCliente.setText(conta.getCidade().getPais().getIdiomaOficial());
            labelErro.setText(" ");
        } catch (ContaNaoExisteException c){
            labelErro.setText("A conta não foi encontrada");
        } catch (Exception e){
            e.printStackTrace();
        }

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

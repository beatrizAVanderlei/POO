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
 * Controlador da tela calcular custos, onde recebe um CPF e mostra os custos do intercâmbio e gera um boleto.
 *
 * @author Gabriel Viana
 */
public class TelaCalcularCustosController implements Initializable {

    @FXML
    private TextField textFieldCpfCliente;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelPrecoPais;
    @FXML
    private Label labelMeses;
    @FXML
    private Label labelReservaEmergencia;
    @FXML
    private Label labelMensalidadeEscola;
    @FXML
    private Label labelMensalidadeHospedagem;
    @FXML
    private Label labelTotal;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaFuncionario fachadaFuncionario;

    public TelaCalcularCustosController() {
        this.fachadaFuncionario = new FachadaFuncionario();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void calcularCustos(ActionEvent event) {
        String cpfCliente = textFieldCpfCliente.getText();

        try {
            if (cpfCliente.length() == 11) {
                Conta conta = this.fachadaFuncionario.consultarConta(cpfCliente);

                labelNome.setText(conta.getCliente().getNomeCompleto());
                labelPrecoPais.setText(String.format("%.2f", conta.getCidade().getPais().getPrecoDaPassagemIdaVolta()));
                labelMeses.setText(String.format("%.2f", conta.getQuantidadeMeses()));
                labelReservaEmergencia.setText(String.format("%.2f", conta.getReservaEmergencia()));
                labelMensalidadeEscola.setText(String.format("%.2f", conta.getEscola().getMensalidade()));
                labelMensalidadeHospedagem.setText(String.format("%.2f", conta.getHospedagem().getMensalidade()));
                labelTotal.setText(String.format("%.2f", conta.calcularCustos()));

                this.fachadaFuncionario.gerarBoleto(conta);
                labelErro.setText("Boleto gerado com sucesso!");

            } else {
                labelErro.setText("CPF inválido!");
            }

        } catch (ContaNaoExisteException cnee) {
            labelErro.setText("Esse cliente não possui um planejamento de intercâmbio!");
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

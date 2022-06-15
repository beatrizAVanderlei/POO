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
import negocio.entidades.*;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAtualizarContaController implements Initializable {
    @FXML
    private TextField textFieldConta;
    @FXML
    private TextField textFieldNomeCidade;
    @FXML
    private TextField textFieldNomeEscola;
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldCliente;
    @FXML
    private TextField textFieldReserva;
    @FXML
    private TextField textFieldMeses;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAtualizarContaController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarContas.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarContasController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvar(ActionEvent actionEvent){
        String CPFAntigo;
        String id;
        String nomeEscola;
        String nomeCidade;
        String clienteCPF;
        int meses;
        double reserva;

        try{
            CPFAntigo = textFieldConta.getText();
            id = textFieldID.getText();
            nomeEscola = textFieldNomeEscola.getText();
            nomeCidade = textFieldNomeCidade.getText();
            clienteCPF = textFieldCliente.getText();
            meses = Integer.parseInt(textFieldMeses.getText());
            reserva = Double.parseDouble(textFieldReserva.getText());
            Conta conta = fachadaAdministrador.consultarConta(CPFAntigo);
            Cidade c = fachadaAdministrador.consultarCidade(nomeCidade);
            Escolas e = fachadaAdministrador.consultarEscola(nomeEscola);
            Cliente cl = fachadaAdministrador.consultarCliente(clienteCPF);
            Hospedagem h = fachadaAdministrador.consultarHospedagem(id);
            fachadaAdministrador.atualizarConta(c, conta, h, cl, e, meses, reserva);
            labelErro.setText("Conta atualizada com sucesso");
        } catch (HospedagemNaoExisteException e) {
            labelErro.setText("A hospedagem selecionada não existe");
        } catch (ReservaInvalidaException e) {
            labelErro.setText("A reserva é um valor inválido");
        } catch (CidadeNaoExisteException e) {
            labelErro.setText("A cidade selecionada não existe");
        } catch (ClienteNaoExisteException e) {
            labelErro.setText("O cliente selecionado não existe");
        } catch (EscolaNaoExisteException e) {
            labelErro.setText("A escola selecionada não existe");
        } catch (ContaNaoExisteException e) {
            labelErro.setText("A conta selecionada não existe");
        } catch (QuantidadeDeMesesInvalidaException e) {
            labelErro.setText("A quantidade de meses é inválida");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar o arquivo");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

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
import negocio.entidades.Cidade;
import negocio.entidades.Cliente;
import negocio.entidades.Escolas;
import negocio.entidades.Hospedagem;
import negocio.fachada.FachadaAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAdicionarContaController implements Initializable {
    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldCPF;
    @FXML
    private TextField textFieldCidade;
    @FXML
    private TextField textFieldEscola;
    @FXML
    private TextField textFieldReserva;
    @FXML
    private TextField textFieldTempo;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAdicionarContaController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage){
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

    @FXML
    public void salvar(ActionEvent actionEvent){
        String nomeCidade = textFieldCidade.getText();
        String nomeEscola = textFieldEscola.getText();
        String idHospedagem = textFieldId.getText();
        String CPFCliente = textFieldCPF.getText();
        double reservaEmergencia = Double.parseDouble(textFieldReserva.getText());
        int meses = Integer.parseInt(textFieldTempo.getText());

        try{
            Cidade c = fachadaAdministrador.consultarCidade(nomeCidade);
            Escolas e = fachadaAdministrador.consultarEscola(nomeEscola);
            Hospedagem h = fachadaAdministrador.consultarHospedagem(idHospedagem);
            Cliente cliente = fachadaAdministrador.consultarCliente(CPFCliente);
            fachadaAdministrador.adicionarConta(c, h, cliente, e, reservaEmergencia, meses);
            labelErro.setText("Conta adicionada com sucesso");
        } catch (HospedagemNaoExisteException e) {
            labelErro.setText("O ID selecionado não é vinculado a nenhuma hospedagem");
        } catch (ReservaInvalidaException e) {
            labelErro.setText("A reserva é abaixo do esperado");
        } catch (CidadeNaoExisteException e) {
            labelErro.setText("A cidade não existe");
        } catch (ClienteNaoExisteException e) {
            labelErro.setText("O cliente não está cadastrado");
        } catch (EscolaNaoExisteException e) {
            labelErro.setText("A escola não existe");
        } catch (QuantidadeDeMesesInvalidaException e) {
            labelErro.setText("Tempo de estadia muito baixo");
        } catch (IOException e) {
            labelErro.setText("Erro na gravação do arquivo");
        } catch (ContaJaAdicionadaException e) {
            labelErro.setText("A conta já foi adicionada");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

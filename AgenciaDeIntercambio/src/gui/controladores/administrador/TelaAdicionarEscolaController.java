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
import negocio.fachada.FachadaAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAdicionarEscolaController implements Initializable {
    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldEndereco;
    @FXML
    private TextField textFieldCidade;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldMensalidade;
    @FXML
    private TextField textFieldAlunos;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAdicionarEscolaController(){
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarEscolas.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarEscolasController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void salvar(ActionEvent actionEvent){
        String nome = textFieldNome.getText();
        String nomeCidade = textFieldCidade.getText();
        String email = textFieldEmail.getText();
        String endereco = textFieldEndereco.getText();
        double mensalidade = Double.parseDouble(textFieldMensalidade.getText());
        int alunos = Integer.parseInt(textFieldAlunos.getText());

        try{
            Cidade c = fachadaAdministrador.consultarCidade(nomeCidade);
            fachadaAdministrador.adicionarEscola(c, email, endereco, nome, alunos, mensalidade);
            labelErro.setText("Escola salva com sucesso");
        } catch (CidadeNaoExisteException e) {
            labelErro.setText("A cidade selecionada não existe");
        } catch (MensalidadeInvalidaException e) {
            labelErro.setText("A mensalidade é inválida");
        } catch (EmailInvalidoException e) {
            labelErro.setText("O e-mail é inválido");
        } catch (NomeInvalidoException e) {
            labelErro.setText("O nome é inválido");
        } catch (EnderecoInvalidoException e) {
            labelErro.setText("O endereço selecionado é inválido");
        } catch (EscolaJaAdicionadaException e) {
            labelErro.setText("A escola já foi adicionada");
        } catch (QuantidadeDeAlunosInvalidaException e) {
            labelErro.setText("Quantidade de alunos muito baixa");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar o arquivo");
        } catch (Exception e){
            labelErro.setText("Escola salva com sucesso");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

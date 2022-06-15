package gui.controladores.administrador;

import excecoes.PaisNaoExisteException;
import excecoes.PrecoDaPassagemInvalidoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;

public class TelaAtualizarPaisController {

    @FXML
    private TextField textFieldPaisAntigo;
    @FXML
    private TextField textFieldPaisNovo;
    @FXML
    private TextField textFieldIdiomaNovo;
    @FXML
    private TextField textFieldPrecoNovo;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAtualizarPaisController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void atualizarPais(ActionEvent event) {
        String paisAntigo = textFieldPaisAntigo.getText();
        String paisNovo = textFieldPaisNovo.getText();
        String idiomaNovo = textFieldIdiomaNovo.getText();
        double precoNovo;
        try {
            precoNovo = Double.parseDouble(textFieldPrecoNovo.getText());
            fachadaAdministrador.atualizarPais(paisAntigo, paisNovo, idiomaNovo, precoNovo);
            labelErro.setText("Atualizado com sucesso!");

        } catch (NumberFormatException nfe) {
            labelErro.setText("Digite apenas números no preço da passagem!");

        } catch (PrecoDaPassagemInvalidoException pdpie) {
            labelErro.setText("Preço da passagem inválido!");

        } catch (PaisNaoExisteException pnee) {
            labelErro.setText("O país a ser atualizado não está no repositório!");

        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarPaises.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarPaisesController) fxmlLoader.getController()).setStage(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

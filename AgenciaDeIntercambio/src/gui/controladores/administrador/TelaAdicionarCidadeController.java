package gui.controladores.administrador;

import excecoes.CidadeJaAdicionadaException;
import excecoes.PaisNaoExisteException;
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

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaAdicionarCidadeController implements Initializable {

    @FXML
    private TextField textFieldNomeCidade;
    @FXML
    private TextField textFieldNomePais;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAdicionarCidadeController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void adicionarCidade(ActionEvent event) {
        try {
            fachadaAdministrador.adicionarCidade(textFieldNomeCidade.getText(), textFieldNomePais.getText());
            labelErro.setText("Adicionado com sucesso!");

        } catch (PaisNaoExisteException pnee) {
            labelErro.setText("O país não existe no repositório!");

        } catch (CidadeJaAdicionadaException cjae) {
            labelErro.setText("Essa cidade já foi adicionada no repositório!");

        } catch (IOException ioe) {
            labelErro.setText("Erro na gravação do arquivo!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarCidades.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarCidadesController) fxmlLoader.getController()).setStage(stage);

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

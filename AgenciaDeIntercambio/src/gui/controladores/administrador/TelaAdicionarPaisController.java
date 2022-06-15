package gui.controladores.administrador;

import excecoes.PaisJaAdicionadoException;
import excecoes.PrecoDaPassagemInvalidoException;
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

public class TelaAdicionarPaisController implements Initializable {

    @FXML
    private TextField textFieldNomePais;
    @FXML
    private TextField textFieldIdiomaPais;
    @FXML
    private TextField textFieldPrecoPassagem;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaAdicionarPaisController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void adicionarPais(ActionEvent event) {
        String nome = textFieldNomePais.getText();
        String idioma = textFieldIdiomaPais.getText();
        double precoPassagem;
        try {
            precoPassagem = Double.parseDouble(textFieldPrecoPassagem.getText());
            fachadaAdministrador.adicionarPais(nome, idioma, precoPassagem);
            labelErro.setText("Adicionado com sucesso!");

        } catch (NumberFormatException nfe) {
            labelErro.setText("Digite apenas números no preço da passagem!");

        } catch (PrecoDaPassagemInvalidoException pdpie) {
            labelErro.setText("Preço da passagem inválido!");

        } catch (PaisJaAdicionadoException pjae) {
            labelErro.setText("Esse país já foi adicionado no repositório!");

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

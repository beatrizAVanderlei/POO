package gui.controladores.administrador;
import excecoes.EscolaNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.entidades.Escolas;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaRemoverEscolaController implements Initializable {
    @FXML
    private TextField textFieldEscola;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverEscolaController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent event) {
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
    public void salvar (ActionEvent actionEvent){
        String nome = textFieldEscola.getText();
        try{
            Escolas e = fachadaAdministrador.consultarEscola(nome);
            fachadaAdministrador.removerEscola(e);
            labelErro.setText("Escola removida com sucesso");
        } catch (EscolaNaoExisteException e) {
            labelErro.setText("A escola não existe no repositório");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar arquivo");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

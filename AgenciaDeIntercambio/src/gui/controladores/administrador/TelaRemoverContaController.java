package gui.controladores.administrador;
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
import negocio.fachada.FachadaAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaRemoverContaController implements Initializable {
    @FXML
    private TextField textFieldCPF;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverContaController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent event) {
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
    public void salvar (ActionEvent actionEvent){
        String CPF = textFieldCPF.getText();
        try{
            Conta conta = fachadaAdministrador.consultarConta(CPF);
            fachadaAdministrador.removerConta(conta);
            labelErro.setText("Cliente removido com sucesso");
        } catch (ContaNaoExisteException e) {
            labelErro.setText("Cliente removido com sucesso");
        } catch (IOException e) {
            labelErro.setText("Cliente removido com sucesso");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

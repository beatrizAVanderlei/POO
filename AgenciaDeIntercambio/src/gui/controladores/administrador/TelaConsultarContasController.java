package gui.controladores.administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import negocio.entidades.Conta;
import negocio.fachada.FachadaAdministrador;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaConsultarContasController implements Initializable {

    @FXML
    private TextArea contas;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaConsultarContasController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void carregarContas(ActionEvent event) {
        ArrayList<Conta> contasArrayList = fachadaAdministrador.consultarTodasAsContas();
        StringBuilder contas = new StringBuilder();

        for (Conta c : contasArrayList) {
            contas.append(c + "\n");
        }

        this.contas.setText(String.valueOf(contas));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

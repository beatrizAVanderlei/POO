package gui.controladores.administrador;

import excecoes.ClienteNaoExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import negocio.entidades.Cliente;
import negocio.fachada.FachadaAdministrador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaRemoverClienteController implements Initializable {
    @FXML
    private TextField textFieldCPF;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaAdministrador fachadaAdministrador;

    public TelaRemoverClienteController() {
        this.fachadaAdministrador = new FachadaAdministrador();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/administrador/TelaGerenciarClientes.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaGerenciarClientesController) fxmlLoader.getController()).setStage(stage);

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
            Cliente c = fachadaAdministrador.consultarCliente(CPF);
            fachadaAdministrador.removerCliente(c);
            labelErro.setText("Cliente removido com sucesso");
        } catch (IOException e) {
            labelErro.setText("Erro ao salvar arquivo");
        } catch (ClienteNaoExisteException e) {
            labelErro.setText("O cliente selecionado não existe");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

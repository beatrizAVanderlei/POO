package gui.controladores.funcionario;

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
import negocio.fachada.FachadaFuncionario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador da tela planejar destino.
 *
 * @author Gabriel Viana
 */
public class TelaPlanejarDestinoController implements Initializable {

    @FXML
    private TextField textFieldCpfCliente;
    @FXML
    private TextField textFieldIdioma;
    @FXML
    private TextField textFieldPais;
    @FXML
    private TextField textFieldCidade;
    @FXML
    private TextField textFieldEscola;
    @FXML
    private TextField textFieldHospedagem;
    @FXML
    private TextField textFieldMeses;
    @FXML
    private Label labelErro;

    private Stage stage;
    private FachadaFuncionario fachadaFuncionario;

    public TelaPlanejarDestinoController() {
        this.fachadaFuncionario = new FachadaFuncionario();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void consultar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/funcionario/TelaConsultarDisponibilidade.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage1 = new Stage();
            ((TelaConsultarDisponibilidadeController) fxmlLoader.getController()).setStage(stage1);
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.show();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    public void salvarPlanejamento(ActionEvent event) {
        String cpfCliente = textFieldCpfCliente.getText();
        String nomeCidade = textFieldCidade.getText();
        String nomeEscola = textFieldEscola.getText();
        String idHospedagem = textFieldHospedagem.getText();

        if (cpfCliente.length() == 11) {

            try {
                double meses = Double.parseDouble(textFieldMeses.getText());
                double reserva;
                if (meses == 1) {
                    reserva = 1000;
                } else if (meses == 2) {
                    reserva = 2000;
                } else {
                    reserva = 3000;
                }

                Cliente cliente = this.fachadaFuncionario.consultarCliente(cpfCliente);
                Cidade cidade = this.fachadaFuncionario.consultarCidade(nomeCidade);
                Escolas escola = this.fachadaFuncionario.consultarEscola(nomeEscola);
                escola.adicionarAlunos();
                Hospedagem hospedagem = this.fachadaFuncionario.consultarHospedagem(idHospedagem);

                if (hospedagem instanceof HostFamily) {
                    if (((HostFamily) hospedagem).getGeneroDoIntercambista() == cliente.getGenero()) {

                        hospedagem.adicionarPessoa();
                        this.fachadaFuncionario.adicionarConta(cidade, hospedagem, cliente, escola, reserva, meses);
                        labelErro.setText("Planejamento criado com sucesso!");

                    } else {
                        labelErro.setText("A hospedagem escolhida n??o est?? dispon??vel!");
                    }
                } else {
                    hospedagem.adicionarPessoa();
                    this.fachadaFuncionario.adicionarConta(cidade, hospedagem, cliente, escola, reserva, meses);
                    labelErro.setText("Planejamento criado com sucesso!");
                }

            } catch (NumberFormatException nfe) {
                labelErro.setText("Digite apenas n??mero em meses");
            } catch (ClienteNaoExisteException cnee) {
                labelErro.setText("Esse cliente ainda n??o possui um cadastro no sistema!");
            } catch (CidadeNaoExisteException cnee) {
                labelErro.setText("A cidade escolhida n??o est?? dispon??vel!");
            } catch (EscolaNaoExisteException | EscolaLotadaException e) {
                labelErro.setText("A escola escolhida n??o est?? dispon??vel!");
            } catch (HospedagemNaoExisteException | HospedagemLotadaException h) {
                labelErro.setText("A hospedagem escolhida n??o est?? dispon??vel!");
            } catch (ReservaInvalidaException rie) {
                labelErro.setText("Reserva inv??lida!");
            } catch (QuantidadeDeMesesInvalidaException qdmee) {
                labelErro.setText("Quantidade de meses inv??lida!");
            } catch (ContaJaAdicionadaException cjae) {
                labelErro.setText("Esse cliente j?? possui um planejmaneto de interc??mbio!");
            } catch (IOException ioe) {
                labelErro.setText("Erro na grava????o do arquivo!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            labelErro.setText("CPF inv??lido!");
        }

    }

    @FXML
    public void voltar(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/telas/funcionario/TelaInicialFuncionario.fxml"));
            Parent root = fxmlLoader.load();
            ((TelaInicialFuncionarioController) fxmlLoader.getController()).setStage(stage);

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

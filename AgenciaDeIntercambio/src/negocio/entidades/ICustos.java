package negocio.entidades;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.FileOutputStream;
import java.io.IOException;

public interface ICustos {

    double calcularCustos();

    static void gerarBoleto(Conta conta) {
        Document document = new Document(PageSize.A5);
        try {

            PdfWriter.getInstance(document, new FileOutputStream("boleto.pdf"));
            document.open();

            Font BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
            Font UNDERLINE = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.UNDERLINE);
            Font NORMAL = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("Agência de Intercâmbio", BOLD));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            Chunk linebreak = new Chunk(new DottedLineSeparator());
            document.add(linebreak);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase("Dados do cliente:", UNDERLINE));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase("Nome: " + conta.getCliente().getNomeCompleto(), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase("CPF: " + conta.getCliente().getCPF(), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase("Custos:", UNDERLINE));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Preço da passagem para o país: R$ %.2f", conta.getCidade().getPais().getPrecoDaPassagemIdaVolta()), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Quantidade de meses do intercâmbio: %.2f", conta.getQuantidadeMeses()), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Reserva de emergência: R$ %.2f", conta.getReservaEmergencia()), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Mensalidade da escola R$ %.2f", conta.getEscola().getMensalidade()), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Mensalidade da hospedagem: R$ %.2f", conta.getHospedagem().getMensalidade()), NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            linebreak = new Chunk(new DottedLineSeparator());
            document.add(linebreak);
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase(String.format("Total: R$ %.2f", conta.calcularCustos()), UNDERLINE));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            document.add(new Paragraph(" "));

            paragraph = new Paragraph();
            paragraph.add(new Phrase("Código do boleto:", NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);

            paragraph = new Paragraph();
            paragraph.add(new Phrase("103558934096.4 23498543.2 35398924.0 981928405.7", NORMAL));
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);


        }
        catch (DocumentException | IOException de) {
            System.err.println(de.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        document.close();
    }
}

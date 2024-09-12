import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class testeEmpresaFaturamento {

    public static void main(String[] args) {
        List<Double> faturamentos = lerFaturamento("faturamentos.xml");

        if (faturamentos.isEmpty()) {
            System.out.println("Nenhum dado de faturamento disponível.");
            return;
        }


        double min = faturamentos.stream().min(Double::compare).orElse(0.0);

        double max = faturamentos.stream().max(Double::compare).orElse(0.0);

        double soma = faturamentos.stream().mapToDouble(Double::doubleValue).sum();

        double media = soma / faturamentos.size();

        long diasAcimaMedia = faturamentos.stream().filter(valor -> valor > media).count();

        System.out.println("Menor valor de faturamento é: " + min);
        System.out.println("Maior valor de faturamento é: " + max);
        System.out.println("Número de dias com faturamento acima da média é:" + diasAcimaMedia);
    }

    private static List<Double> lerFaturamento(String caminhoArquivo) {
        List<Double> faturamentos = new ArrayList<>();

        try {

            File documento = new File(caminhoArquivo);
            DocumentBuilderFactory dbc = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbc.newDocumentBuilder();
            Document doc = db.parse(documento);
            doc.getDocumentElement().normalize();

            NodeList listaDeNos = doc.getElementsByTagName("dia");

            for (int temporario = 0; temporario < listaDeNos.getLength(); temporario++) {
                Node nNode = listaDeNos.item(temporario);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    double valor = Double.parseDouble(eElement.getElementsByTagName("valor").item(0).getTextContent());
                    faturamentos.add(valor);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return faturamentos;
    }
}
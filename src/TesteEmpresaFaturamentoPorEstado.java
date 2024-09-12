
import java.util.function.BiFunction;
import java.util.Arrays;
import java.util.stream.IntStream;


public class TesteEmpresaFaturamentoPorEstado {
    public static void main(String[] args) {
        // Valores de faturamento por estado

        double[] valores = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};
        String[] estadosAbreviados = {"SP", "RJ", "MG", "ES", "Outros"};


        BiFunction<Double,Double,Double> valoresPorcentual= 
                (valor,totalSoma) -> (valor / totalSoma) * 100;

        BiFunction<String, Double, String> trataString = 
                (nomeEstado, valorPorcentado) -> nomeEstado + ": " + valorPorcentado + "%";
        
        double total = Arrays.stream(valores).sum();

        IntStream.range(0, valores.length)
        .mapToObj(i -> trataString.apply(estadosAbreviados[i], valoresPorcentual.apply(valores[i], total)))
        .forEach(System.out::println);
    }
}

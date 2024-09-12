import java.util.Scanner;

public class TesteEmpresaStringAoContrario {

    public static void main(String[] args) {

        System.out.println("A palavra invertida ficaria: " + String.valueOf(inverteLetras(lePalavra())));

    }

    public static String inverteLetras(String nomeParaInverter){
        
        char[]  
        aux = new char[1],
        arrayDeLetras = nomeParaInverter.toCharArray();
        
        int  
        p = 0, 
        u= nomeParaInverter.length() -1, 
        n = arrayDeLetras.length/2;

        for (int i = 0; i < n; i++) {
            if(p == u){
                arrayDeLetras[p] = arrayDeLetras[u];
            }else{
                aux[0] = arrayDeLetras[p];
                arrayDeLetras[p] = arrayDeLetras[u];
                arrayDeLetras[u] = aux[0];

                p++;
                u--;
            } 
        }

        String resultInvertido = String.valueOf(arrayDeLetras);
        return resultInvertido;
    }

    public static String lePalavra(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a palavra a ser invertida: ");

        String palavra;
        palavra = scanner.nextLine();

        return palavra;
    }
}

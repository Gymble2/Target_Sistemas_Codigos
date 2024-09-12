import java.util.Scanner;

public class TesteEmpresa {
	
	
	
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o número para teste do fibonacci: ");
        int number = scanner.nextInt();
        scanner.close();
        
        if(fibonacciTesteValor(number)) {
        	System.out.println("O numero informado:"+ number + "  -> é  parte da sequencia");
        }else {
        	System.out.println("O numero informado:"+ number + "  -> não é parte da sequencia");
        }
        
	}

	public static boolean fibonacciTesteValor(int elemento) {
			
		int a = 0, b = 1;
		
        if(elemento < 0) {
        	return false;
        }    
       
        while (b < elemento) {
            int temporario = b;
            b = a + b;
            a = temporario;
        }
        return b == elemento || a == elemento;
    }
}

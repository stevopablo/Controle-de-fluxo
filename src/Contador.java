import java.util.Scanner;

public class Contador {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            System.out.println("Digite o primeiro número: ");
            int primeiroNumero = input.nextInt();

            System.out.println("Digite o segundo número: ");
            int segundoNumero = input.nextInt();

            contar(primeiroNumero, segundoNumero);
        } catch (ParametrosInvalidosException e) {
            System.out.println(e.getMessage());
        }
    }

    static void contar(int n1, int n2) throws ParametrosInvalidosException {
        if (n1 > n2) {
            throw new ParametrosInvalidosException("O segundo número deve ser maior que o primeiro");
        }

        int contagem = n2 - n1;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}

import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) throws Exception {
        selecaoCandidatos();
        imprimirSelecionados();
    }

    static void ligarCandidato(String candidato){
        int tentativas = 1;
        boolean continuar = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuar = !atendeu;
            if (continuar) {
                tentativas++;
            } else {  
                System.out.println("Contato realizado com sucesso.");
            }
        } while (continuar && tentativas < 3);

        if (atendeu) {
            System.out.println("Conseguimos contato com " + candidato + " após " + tentativas + " tentativas.");
        } else {
            System.out.println("Não conseguimos contato com " + candidato + ". Número de tentativas: " + tentativas);
        }
    }

    static boolean atender() {
        return ThreadLocalRandom.current().nextInt(3) == 1; 
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"JOÃO", "MARCIA", "LUPITA", "PIENTRA", "CAMILA"};
        for (String candidato : candidatos) {
            System.out.println("Candidato selecionado: " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"JOÃO", "MARCIA", "LUPITA", "PIENTRA", "CAMILA", "ARLOS", "JUHU", "OROCHI", "BEN"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            
            System.out.printf("O candidato: %s, Salário pretendido: %.2f%n", candidato, salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato.");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta.");
        } else {
            System.out.println("Esperar o resultado de outros candidatos.");
        }
    }
}

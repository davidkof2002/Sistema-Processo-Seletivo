import java.util.concurrent.ThreadLocalRandom;

public class Candidatura {
    public static void main(String[] args) {
        imprimirSelecionados();
        selecaoCandidatos();
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"David", "Felipe", "William", "Carlos", "Vinicios"};

        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento:");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
        }
    }

    static void selecaoCandidatos() {
        String[] candidatos = {"David", "Felipe", "William", "Carlos", "Vinicios", "João", "Estela", "Jose", "Maria", "Lis"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        final double SALARIO_BASE = 2000.0;  // Definição de constante para salário base

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);

            if (SALARIO_BASE >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        final double SALARIO_BASE = 2000.0;

        if (SALARIO_BASE > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (SALARIO_BASE == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA-PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}

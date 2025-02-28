import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidato {
    String nome;
    int idade;
    String endereco;
    String telefone;
    int experienciaJava;
    double salarioPretendido;

    public Candidato(String nome, int idade, String endereco, String telefone, int experienciaJava, double salarioPretendido) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.experienciaJava = experienciaJava;
        this.salarioPretendido = salarioPretendido;
    }
}

public class Candidat {
    private static final double SALARIO_BASE = 5000.0;
    private static final String LOCAL_APROVADO = "Centro";
    private static final int EXPERIENCIA_MINIMA = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Candidato> candidatos = cadastrarCandidatos();
        List<Candidato> aprovados = new ArrayList<>();
        List<Candidato> futurasContratacoes = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (isAprovado(candidato)) {
                aprovados.add(candidato);
            } else {
                futurasContratacoes.add(candidato);
            }
        }

        exibirLista("Aprovados", aprovados);
        exibirLista("Futuras Contratações", futurasContratacoes);
        
        scanner.close();
    }

    private static List<Candidato> cadastrarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        System.out.println("Quantos candidatos deseja cadastrar?");
        int totalCandidatos = validarEntradaInt();

        for (int i = 0; i < totalCandidatos; i++) {
            System.out.println("\nCadastro do candidato " + (i + 1));
            
            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = validarEntradaInt();

            System.out.print("Endereço (ex: Centro, Bairro X...): ");
            String endereco = scanner.nextLine();

            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();

            System.out.print("Anos de experiência com Java: ");
            int experienciaJava = validarEntradaInt();

            System.out.print("Salário pretendido: ");
            double salarioPretendido = validarEntradaDouble();

            candidatos.add(new Candidato(nome, idade, endereco, telefone, experienciaJava, salarioPretendido));
        }
        return candidatos;
    }

    private static boolean isAprovado(Candidato candidato) {
        return candidato.idade >= 18 &&
               candidato.endereco.contains(LOCAL_APROVADO) &&
               candidato.experienciaJava >= EXPERIENCIA_MINIMA &&
               candidato.salarioPretendido <= SALARIO_BASE;
    }

    private static void exibirLista(String titulo, List<Candidato> lista) {
        System.out.println("\nLista de " + titulo + ":");
        if (lista.isEmpty()) {
            System.out.println("Nenhum candidato na lista de " + titulo.toLowerCase() + ".");
        } else {
            for (Candidato c : lista) {
                System.out.println("Nome: " + c.nome + ", Telefone: " + c.telefone);
            }
        }
    }

    private static int validarEntradaInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida! Digite um número inteiro: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    private static double validarEntradaDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada inválida! Digite um número válido: ");
            scanner.next();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}

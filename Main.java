import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Metro metro = new Metro();
        Scanner read = new Scanner(System.in);

        System.out.println("Digite a estação de origem:");
        String origemNome = read.nextLine();

        System.out.println("Digite a estação de destino:");
        String destinoNome = read.nextLine();

        Estacao origem = metro.buscarEstacao(origemNome);
        Estacao destino = metro.buscarEstacao(destinoNome);

        if (origem == null || destino == null) {
            System.out.println("Estação inválida!");
            return;
        }

        List<Estacao> caminho = metro.caminhoMaisRapido(origem, destino);
        Map<Estacao, Double> tempos = metro.dijkstra(origem);

        System.out.println("Caminho mais rápido:");
        for (Estacao e : caminho) {
            System.out.print(e.getNome());
            if (!e.equals(destino))
                System.out.print(" -> ");
        }
        System.out.println("\nTempo estimado: " + tempos.get(destino) + " minutos");
    }
}
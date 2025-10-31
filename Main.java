import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Metro metro = new Metro();
        int menu = 0;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("Escolha uma das opcões: ");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar nova rota");
            menu = read.nextInt();
            read.nextLine();

            if (menu == 1) {

                System.out.println("Digite a estação de origem:");
                String origemNome = read.nextLine();

                System.out.println("Digite a estação de destino:");
                String destinoNome = read.nextLine();

                Estacao origem = metro.buscarEstacao(origemNome);
                Estacao destino = metro.buscarEstacao(destinoNome);

                while (origem == null || destino == null) {
                    System.out.println("Estação invalida! Digite novamente.");

                    if (origem == null) {
                        System.out.println("Digite a estacao de origem:");
                        origemNome = read.nextLine();
                        origem = metro.buscarEstacao(origemNome);
                    }

                    if (destino == null) {
                        System.out.println("Digite a estacao de destino:");
                        destinoNome = read.nextLine();
                        destino = metro.buscarEstacao(destinoNome);
                    }
                }

                List<Estacao> caminho = metro.caminhoMaisRapido(origem, destino);
                Map<Estacao, Double> tempos = metro.dijkstra(origem);

                for (Estacao estacao : caminho) {
                    System.out.print(estacao.getNome());
                    if (!estacao.equals(destino)) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println("\nTempo estimado: " + tempos.get(destino) + " minutos");

            } else {
                break;
            }

        } while (menu != 0);
    };
};
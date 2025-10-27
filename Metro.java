import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Metro {
    private final Map<Estacao, List<Conexao>> adjacencias = new HashMap<>();
    private final Map<String, Estacao> estacoesPorNome = new HashMap<>();

    public Metro() {
        // Inicializa todas as estações da Linha 1-Azul
        adicionarEstacao("JABAQUARA", "Jabaquara");
        adicionarEstacao("CONCEICAO", "Conceição");
        adicionarEstacao("SAOJUDAS", "São Judas");
        adicionarEstacao("SAUDE", "Saúde");
        adicionarEstacao("PRACA_ARVORE", "Praça da Árvore");
        adicionarEstacao("SANTA_CRUZ", "Santa Cruz");
        adicionarEstacao("VILA_MARIANA", "Vila Mariana");
        adicionarEstacao("ANA_ROSA", "Ana Rosa");
        adicionarEstacao("PARAISO", "Paraíso");
        adicionarEstacao("SE", "Sé");
        adicionarEstacao("TIRADENTES", "Tiradentes");
        adicionarEstacao("PORTUGAL", "Portuguesa-Tietê"); // exemplo fictício

        // Adiciona conexões (tempos aproximados em minutos)
        adicionarConexao("JABAQUARA", "CONCEICAO", 2.0);
        adicionarConexao("CONCEICAO", "SAOJUDAS", 2.5);
        adicionarConexao("SAOJUDAS", "SAUDE", 1.5);
        adicionarConexao("SAUDE", "PRACA_ARVORE", 2.0);
        adicionarConexao("PRACA_ARVORE", "SANTA_CRUZ", 2.5);
        adicionarConexao("SANTA_CRUZ", "VILA_MARIANA", 2.0);
        adicionarConexao("VILA_MARIANA", "ANA_ROSA", 1.8);
        adicionarConexao("ANA_ROSA", "PARAISO", 1.2);
        adicionarConexao("PARAISO", "SE", 2.5);
        adicionarConexao("SE", "TIRADENTES", 3.0);
        adicionarConexao("TIRADENTES", "PORTUGAL", 2.5);
    }

    private void adicionarEstacao(String id, String nome) {
        Estacao e = new Estacao(id, nome);
        adjacencias.putIfAbsent(e, new ArrayList<>());
        estacoesPorNome.put(nome.toLowerCase(), e);
    }

    private void adicionarConexao(String nome1, String nome2, double tempo) {
        Estacao e1 = estacoesPorNome.get(nome1.toLowerCase());
        Estacao e2 = estacoesPorNome.get(nome2.toLowerCase());
        adjacencias.get(e1).add(new Conexao(e2, tempo));
        adjacencias.get(e2).add(new Conexao(e1, tempo));
    }

    public Estacao buscarEstacao(String nome) {
        return estacoesPorNome.get(nome.toLowerCase());
    }

    // Dijkstra para menor tempo
    public Map<Estacao, Double> dijkstra(Estacao origem) {
        Map<Estacao, Double> tempoMinimo = new HashMap<>();
        for (Estacao e : adjacencias.keySet()) {
            tempoMinimo.put(e, Double.POSITIVE_INFINITY);
        }
        tempoMinimo.put(origem, 0.0);

        PriorityQueue<Estacao> fila = new PriorityQueue<>(Comparator.comparingDouble(tempoMinimo::get));
        fila.add(origem);

        while (!fila.isEmpty()) {
            Estacao atual = fila.poll();
            for (Conexao conexao : adjacencias.get(atual)) {
                double novoTempo = tempoMinimo.get(atual) + conexao.getTempo();
                if (novoTempo < tempoMinimo.get(conexao.getDestino())) {
                    tempoMinimo.put(conexao.getDestino(), novoTempo);
                    fila.remove(conexao.getDestino());
                    fila.add(conexao.getDestino());
                }
            }
        }
        return tempoMinimo;
    }

    // Caminho mais rápido de origem até destino
    public List<Estacao> caminhoMaisRapido(Estacao origem, Estacao destino) {
        Map<Estacao, Double> tempoMinimo = new HashMap<>();
        Map<Estacao, Estacao> anterior = new HashMap<>();
        for (Estacao e : adjacencias.keySet()) {
            tempoMinimo.put(e, Double.POSITIVE_INFINITY);
        }
        tempoMinimo.put(origem, 0.0);

        PriorityQueue<Estacao> fila = new PriorityQueue<>(Comparator.comparingDouble(tempoMinimo::get));
        fila.add(origem);

        while (!fila.isEmpty()) {
            Estacao atual = fila.poll();
            if (atual.equals(destino))
                break;
            for (Conexao conexao : adjacencias.get(atual)) {
                double novoTempo = tempoMinimo.get(atual) + conexao.getTempo();
                if (novoTempo < tempoMinimo.get(conexao.getDestino())) {
                    tempoMinimo.put(conexao.getDestino(), novoTempo);
                    anterior.put(conexao.getDestino(), atual);
                    fila.remove(conexao.getDestino());
                    fila.add(conexao.getDestino());
                }
            }
        }

        List<Estacao> caminho = new ArrayList<>();

        Estacao passo = destino;

        while (passo != null) {
            caminho.add(0, passo);
            passo = anterior.get(passo);
        }
        if (!caminho.get(0).equals(origem))
            return Collections.emptyList();
        return caminho;
    };
};
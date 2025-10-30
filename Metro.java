import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Metro {
    // adjacencias seriam as conexões entre as
    // arestas ou entre uma estação e outra, se
    // for pensar no caso do problema
    private final Map<Estacao, List<Conexao>> adjacencias = new HashMap<>();
    private final Map<String, Estacao> estacoesPorNome = new HashMap<>();

    public Metro() {
        // Inicializa todas as estações da Linha 1-Azul
        adicionarEstacao("JABAQUARA", "Jabaquara");
        adicionarEstacao("CONCEICAO", "Conceicao");
        adicionarEstacao("SAOJUDAS", "Sao Judas");
        adicionarEstacao("SAUDE", "Saude");
        adicionarEstacao("PRACA_ARVORE", "Praca da Arvore");
        adicionarEstacao("SANTA_CRUZ", "Santa Cruz");
        adicionarEstacao("VILA_MARIANA", "Vila Mariana");
        adicionarEstacao("ANA_ROSA", "Ana Rosa");
        adicionarEstacao("PARAISO", "Paraiso");
        adicionarEstacao("VERGUEIRO", "Vergueiro");
        adicionarEstacao("SAO_JOAQUIM", "Sao Joaquim");
        adicionarEstacao("LIBERDADE", "Liberdade");
        adicionarEstacao("SE", "Se");
        adicionarEstacao("SAO_BENTO", "Sao Bento");
        adicionarEstacao("LUZ", "Luz");
        adicionarEstacao("TIRADENTES", "Tiradentes");
        adicionarEstacao("ARMENIA", "Armenia");
        adicionarEstacao("PORTUGUESA-TIETE", "Portuguesa-tiete");
        adicionarEstacao("CARANDIRU", "Carandiru");

        // Adiciona conexões (tempos aproximados em minutos)
        adicionarConexao("Jabaquara", "Conceicao", 2.0);
        adicionarConexao("Conceicao", "Sao Judas", 2.5);
        adicionarConexao("Sao Judas", "Saude", 1.5);
        adicionarConexao("Saude", "Praca da Arvore", 2.0);
        adicionarConexao("Praca da Arvore", "Santa Cruz", 2.5);
        adicionarConexao("Santa Cruz", "Vila Mariana", 2.0);
        adicionarConexao("Vila Mariana", "Ana Rosa", 1.8);
        adicionarConexao("Ana Rosa", "Paraiso", 1.2);
        adicionarConexao("Paraiso", "Vergueiro", 1.6);
        adicionarConexao("Vergueiro", "Sao Joaquim", 1.7);
        adicionarConexao("Sao Joaquim", "Liberdade", 1.3);
        adicionarConexao("Liberdade", "Se", 1.3);
        adicionarConexao("Se", "Sao Bento", 1.3);
        adicionarConexao("Sao Bento", "Luz", 1.9);
        adicionarConexao("Luz", "Tiradentes", 3.0);
        adicionarConexao("Tiradentes", "Armenia", 3.2);
        adicionarConexao("Armenia", "Portuguesa-tiete", 2.4);
        adicionarConexao("Portuguesa-tiete", "Carandiru", 2.2);

    };

    private void adicionarEstacao(String id, String nome) {
        Estacao e = new Estacao(id, nome);
        // Estamos usando o putIfAbsent pois ele cria a lista caso ainda não exista,
        // fazendo assim com que nós não
        // precisemos realizar uma validação a mais para isso
        adjacencias.putIfAbsent(e, new ArrayList<>());
        estacoesPorNome.put(nome.toLowerCase(), e);
    }

    private void adicionarConexao(String nome1, String nome2, double tempo) {
        Estacao e1 = estacoesPorNome.get(nome1.toLowerCase());
        Estacao e2 = estacoesPorNome.get(nome2.toLowerCase());

        adjacencias.putIfAbsent(e1, new ArrayList<>());
        adjacencias.putIfAbsent(e2, new ArrayList<>());
        adjacencias.get(e1).add(new Conexao(e2, tempo));
        adjacencias.get(e2).add(new Conexao(e1, tempo)); // opcional, se for bidirecional
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

        tempoMinimo.put(origem, 0.00);

        PriorityQueue<Estacao> fila = new PriorityQueue<>(Comparator.comparingDouble(tempoMinimo::get));
        fila.add(origem);

        while (!fila.isEmpty()) {
            Estacao atual = fila.poll();
            for (Conexao conexao : adjacencias.get(atual)) {
                double novoTempo = tempoMinimo.get(atual) + conexao.getTempo();
                if (novoTempo < tempoMinimo.get(conexao.getDestino())) {
                    System.out.println(
                            "Novo Tempo " + novoTempo + " < Tempo Minimo" + tempoMinimo.get(conexao.getDestino()));
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

        if (!caminho.get(0).equals(origem)) {
            return Collections.emptyList();
        }
        return caminho;
    };
};
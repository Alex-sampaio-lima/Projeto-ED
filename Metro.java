
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
        adicionarEstacao("PORTUGUESA_TIETE", "Portuguesa-tiete");
        adicionarEstacao("CARANDIRU", "Carandiru");
        adicionarEstacao("SANTANA", "Santana");
        adicionarEstacao("JARDIM_SAO_PAULO_AYRTON_SENNA", "Jardim Sao Paulo-Ayrton Senna");
        adicionarEstacao("PARADA_INGLESA", "Parada Inglesa");
        adicionarEstacao("TUCURUVI", "Tucuruvi");
        adicionarEstacao("", "");
        adicionarEstacao("", "");

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
        adicionarConexao("Carandiru", "Santana", 2.2);
        adicionarConexao("Santana", "Jardim Sao Paulo-Ayrton Senna", 2.2);
        adicionarConexao("Jardim Sao Paulo-Ayrton Senna", "Parada Inglesa", 1.1);
        adicionarConexao("Parada Inglesa", "Tucuruvi", 1.5);

        // Inicializa todas as estações da Linha 2-Verde
        adicionarEstacao("VILA_PRUDENTE", "Vila Prudente");
        adicionarEstacao("TAMANDUATEI", "Tamanduatei");
        adicionarEstacao("SACOMA", "Sacoma");
        adicionarEstacao("ALTO_DO_IPIRANGA", "Alto do Ipiranga");
        adicionarEstacao("SANTOS_IMIGRANTES", "Santos Imigrantes");
        adicionarEstacao("CHACARA_KLABIN", "Chacara Klabin");
        adicionarEstacao("BRIGADEIRO", "Brigadeiro");
        adicionarEstacao("TRIANON_MASP", "Trianon Masp");
        adicionarEstacao("CONSOLACAO", "Consolacao");
        adicionarEstacao("CLINICAS", "Clinicas");
        adicionarEstacao("SUMARE", "Sumare");
        adicionarEstacao("VILA_MADALENA", "Vila Madalena");

        // Adiciona conexões (tempos aproximados em minutos)
        adicionarConexao("Vila Prudente", "Tamanduatei", 2.0);
        adicionarConexao("Tamanduatei", "Sacoma", 2.0);
        adicionarConexao("Sacoma", "Alto do Ipiranga", 2.0);
        adicionarConexao("Alto do Ipiranga", "Santos Imigrantes", 2.5);
        adicionarConexao("Santos-Imigrantes", "Chacara Klabin", 2.0);
        adicionarConexao("Chacara Klabin", "Ana Rosa", 1.5); // Conexão com a Linha 1
        adicionarConexao("Ana Rosa", "Paraiso", 1.2); // Conexão com Linha 1
        adicionarConexao("Paraiso", "Brigadeiro", 2.0);
        adicionarConexao("Brigadeiro", "Trianon Masp", 1.5);
        adicionarConexao("Trianon Masp", "Consolacao", 1.8);
        adicionarConexao("Consolacao", "Clinicas", 2.3);
        adicionarConexao("Clinicas", "Sumare", 2.1);
        adicionarConexao("Sumare", "Vila Madalena", 2.0);

        // Inicializa todas as estacoes da Linha 3-Vermelha
        adicionarEstacao("CORINTHIANS_ITAQUERA", "Corinthians Itaquera");
        adicionarEstacao("ARTUR_ALVIM", "Artur Alvim");
        adicionarEstacao("PATRIARCA", "Patriarca");
        adicionarEstacao("GUILHERMINA_ESPERANCA", "Guilhermina Esperanca");
        adicionarEstacao("VILA_MATILDE", "Vila Matilde");
        adicionarEstacao("PENHA", "Penha");
        adicionarEstacao("CARRAO", "Carrao");
        adicionarEstacao("TATUAPE", "Tatuape");
        adicionarEstacao("BELEM", "Belem");
        adicionarEstacao("BRESSER_MOOCA", "Bresser Mooca");
        adicionarEstacao("BRAS", "Bras");
        adicionarEstacao("PEDRO_II", "Pedro II");
        adicionarEstacao("SE", "Se");
        adicionarEstacao("ANHANGABAU", "Anhangabau");
        adicionarEstacao("REPUBLICA", "Republica");
        adicionarEstacao("SANTA_CECILIA", "Santa Cecilia");
        adicionarEstacao("MARECHAL_DEODORO", "Marechal Deodoro");
        adicionarEstacao("PALMEIRAS_BARRA_FUNDA", "Palmeiras Barra Funda");

        // Adiciona conexoes (tempos aproximados em minutos)
        adicionarConexao("Corinthians-Itaquera", "Artur Alvim", 2.0);
        adicionarConexao("Artur Alvim", "Patriarca", 2.0);
        adicionarConexao("Patriarca", "Guilhermina-Esperanca", 1.5);
        adicionarConexao("Guilhermina-Esperanca", "Vila Matilde", 1.7);
        adicionarConexao("Vila Matilde", "Penha", 2.0);
        adicionarConexao("Penha", "Carrao", 2.1);
        adicionarConexao("Carrao", "Tatuape", 2.0);
        adicionarConexao("Tatuape", "Belem", 2.0);
        adicionarConexao("Belem", "Bresser Mooca", 2.1);
        adicionarConexao("Bresser Mooca", "Bras", 2.3);
        adicionarConexao("Bras", "Pedro II", 1.7);
        adicionarConexao("Pedro II", "Se", 1.6); // conexao com Linha 1-Azul
        adicionarConexao("Se", "Anhangabau", 1.5);
        adicionarConexao("Anhangabau", "Republica", 1.3); // conexao com Linha 4-Amarela
        adicionarConexao("Republica", "Santa Cecilia", 1.8);
        adicionarConexao("Santa Cecilia", "Marechal Deodoro", 1.9);
        adicionarConexao("Marechal Deodoro", "Palmeiras Barra Funda", 2.4);

        // Inicializa todas as estacoes da Linha 4–Amarela
        adicionarEstacao("LUZ", "Luz");
        adicionarEstacao("REPUBLICA", "Republica");
        adicionarEstacao("HIGIENOPOLIS_MACENZIE", "Higienopolis Mackenzie");
        adicionarEstacao("PAULISTA", "Paulista");
        adicionarEstacao("OSCAR_FREIRE", "Oscar Freire");
        adicionarEstacao("FRADIQUE_COUTINHO", "Fradique Coutinho");
        adicionarEstacao("FARIA_LIMA", "Faria Lima");
        adicionarEstacao("PINHEIROS", "Pinheiros");
        adicionarEstacao("BUTANTA", "Butanta");
        adicionarEstacao("SAO_PAULO_MORUMBI", "São Paulo Morumbi");
        adicionarEstacao("VILA_SONIA", "Vila Sônia");

        // Adiciona conexoes (tempos aproximados em minutos)
        adicionarConexao("Luz", "Republica", 2.5); // conexao com Linha 1-Azul e 3-Vermelha
        adicionarConexao("Republica", "Higienopolis Mackenzie", 1.8);
        adicionarConexao("Higienopolis Mackenzie", "Paulista", 1.3); // conexao com Linha 2-Verde
        adicionarConexao("Paulista", "Oscar Freire", 1.5);
        adicionarConexao("Oscar Freire", "Fradique Coutinho", 2.0);
        adicionarConexao("Fradique Coutinho", "Faria Lima", 1.8);
        adicionarConexao("Faria Lima", "Pinheiros", 2.0); // conexao com CPTM Linha 9–Esmeralda
        adicionarConexao("Pinheiros", "Butanta", 2.2);
        adicionarConexao("Butanta", "Sao Paulo Morumbi", 2.5);
        adicionarConexao("Sao Paulo Morumbi", "Vila Sonia", 2.0);

        // Inicializa todas as estacoes da Linha 9–Esmeralda (CPTM)
        adicionarEstacao("OSASCO", "Osasco");
        adicionarEstacao("PRESIDENTE_ALTINO", "Presidente Altino");
        adicionarEstacao("CEASA", "Ceasa");
        adicionarEstacao("VILLA_LOPES_REIS", "Villa Lobos Jaguare");
        adicionarEstacao("CIDADE_UNIVERSITARIA", "Cidade Universitaria");
        adicionarEstacao("PINHEIROS", "Pinheiros");
        adicionarEstacao("HEBATIA", "Hebraica Rebouças");
        adicionarEstacao("CIDADE_JARDIM", "Cidade Jardim");
        adicionarEstacao("VILA_OLIMPIA", "Vila Olimpia");
        adicionarEstacao("BERINI", "Berrini");
        adicionarEstacao("MORUMBI", "Morumbi");
        adicionarEstacao("GRANJA_JULIETA", "Granja Julieta");
        adicionarEstacao("JOAO_DIAS", "Joao Dias");
        adicionarEstacao("SANTO_AMARO", "Santo Amaro");
        adicionarEstacao("SOCORRO", "Socorro");
        adicionarEstacao("JURUBATUBA", "Jurubatuba");
        adicionarEstacao("AUTODROMO", "Autodromo");
        adicionarEstacao("INTERLAGOS", "Interlagos");
        adicionarEstacao("GRAJAU", "Grajau");
        adicionarEstacao("MENDES_VILA_NATAL", "Mendes Vila Natal");
        adicionarEstacao("VARGINHA", "Varginha");

        // Adiciona conexoes (tempos aproximados em minutos)
        adicionarConexao("Osasco", "Presidente Altino", 2.5);
        adicionarConexao("Presidente Altino", "Ceasa", 2.3);
        adicionarConexao("Ceasa", "Villa-Lobos Jaguaré", 2.2);
        adicionarConexao("Villa-Lobos Jaguaré", "Cidade Universitária", 1.8);
        adicionarConexao("Cidade Universitária", "Pinheiros", 1.5); // conexão com Linha 4-Amarela
        adicionarConexao("Pinheiros", "Hebraica Rebouças", 1.7);
        adicionarConexao("Hebraica Rebouças", "Cidade Jardim", 1.5);
        adicionarConexao("Cidade Jardim", "Vila Olimpia", 2.0);
        adicionarConexao("Vila Olimpia", "Berrini", 1.5);
        adicionarConexao("Berrini", "Morumbi", 2.0);
        adicionarConexao("Morumbi", "Granja Julieta", 1.8);
        adicionarConexao("Granja Julieta", "Joao Dias", 1.8);
        adicionarConexao("Joao Dias", "Santo Amaro", 1.5); // conexão com Linha 5–Lilás
        adicionarConexao("Santo Amaro", "Socorro", 1.7);
        adicionarConexao("Socorro", "Jurubatuba", 2.0);
        adicionarConexao("Jurubatuba", "Autódromo", 2.3);
        adicionarConexao("Autodromo", "Interlagos", 2.5);
        adicionarConexao("Interlagos", "Grajau", 2.7);
        adicionarConexao("Grajaú", "Mendes Vila Natal", 3.5);
        adicionarConexao("Mendes Vila Natal", "Varginha", 3.0);

    }

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
                    // System.out.println("Novo Tempo " + novoTempo + " < Tempo Minimo" +
                    // tempoMinimo.get(conexao.getDestino()));
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
            if (atual.equals(destino)) {
                break;
            }
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
    }
;
};

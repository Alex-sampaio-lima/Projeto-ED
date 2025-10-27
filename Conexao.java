public class Conexao {
    private final Estacao destino;
    private final double tempo; // em minutos

    public Conexao(Estacao destino, double tempo) {
        this.destino = destino;
        this.tempo = tempo;
    }

    public Estacao getDestino() {
        return destino;
    };

    public double getTempo() {
        return tempo;
    };

};

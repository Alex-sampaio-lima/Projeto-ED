import java.util.Objects;

public class Estacao {

    private final String id;
    private final String nome;

    public Estacao(String id, String nome) {
        this.id = id;
        this.nome = nome;
    };

    public String getId() {
        return id;
    };

    public String getNome() {
        return nome;
    };

    @Override
    public boolean equals(Object o) {
        // Aqui verificamos se os objetos são os mesmo na memória(mesmo endereço)
        if (this == o) {
            return true;
        }
        // Aqui estamos verificando se o Objeto o é uma instância da classe Estacao, se
        // não for os objetos não são considerados iguais
        if (!(o instanceof Estacao)) {
            return false;
        }
        // Aqui fazemos um cast do objeto o para forçar ele ser do Tipo Estacao, e dessa
        // forma
        // acessar os métodos de Estacao
        Estacao estacao = (Estacao) o;
        // Aqui temos mais uma comparação desta vez estamos comparando os ids
        return id.equals(estacao.id);
    };

    @Override
    public int hashCode() {
        return Objects.hash(id);
    };

    @Override
    public String toString() {
        return nome;
    };
};
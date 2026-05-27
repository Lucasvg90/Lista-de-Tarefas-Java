package objeto;

public enum Prioridade {

    BAIXA(1, "Baixa"),
    MEDIA(2, "Média"),
    ALTA(3, "Alta"),
    URGENTE(4, "Urgente");

    private final int codigo;
    private final String descricao;

    Prioridade(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade pegaPrioridade(int codigo) {
        for (Prioridade p : Prioridade.values()){
            if(p.codigo == codigo){
                return p;
            }
        }
        throw new IllegalArgumentException("Código de prioridade inválido: " + codigo);
    }
}

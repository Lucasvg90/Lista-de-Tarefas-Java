package objeto;

public enum Status {
    PENDENTE(1, "Pendente"),
    CONCLUIDO(2, "Concluído"),
    ATRASADO(3, "Atrasado");

    private final int codigo;
    private final String descricao;

    Status(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status pegaStatus(int codigo) {
        for (Status s : Status.values()){
            if(s.codigo == codigo){
                return s;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }

}

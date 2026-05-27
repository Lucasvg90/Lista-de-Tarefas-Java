package objeto;

public class Pessoa {

    private String nome;
    private int id;
    private static int contador = 1;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = contador++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }


}

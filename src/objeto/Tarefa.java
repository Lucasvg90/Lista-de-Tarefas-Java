package objeto;

import java.util.Scanner;

public class Tarefa {


    private String nome, descricao;
    private int prioridade, status, id, id_usuario;
    private static int contador = 1;

    public Tarefa(String nome, String descricao, int prioridade, int status, int id_usuario) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.id_usuario = id_usuario;
        this.id = contador++;
    }

    public static Tarefa criar(Scanner scan){

        System.out.println("Informe o nome da tarefa: ");
        String nome = scan.nextLine();

        System.out.println("Dê uma descrição mais detalhada sobre a tarefa: ");
        String descricao = scan.nextLine();

        System.out.println("Defina o nível de prioridade: 1- Baixa | 2- Média | 3- Alta | 4- Urgente");
        int prioridade = scan.nextInt();

        System.out.println("Informe o status atual: 1- Pendente | 2- Concluído");
        int status = scan.nextInt();

        System.out.println("Informe o ID da pessoa responsável:");
        int id_usuario = scan.nextInt();

        return new Tarefa(nome, descricao, prioridade, status, id_usuario);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "Id Tarefa:" + id + "\n" +
                " Nome da tarefa: " + nome + "\n" +
                " Descricao: " + descricao + "\n" +
                " Prioridade: " + prioridade + "\n" +
                " Status: " + status + "\n" +
                " Responsável: " + id_usuario + "\n" + "\n";
    }
}

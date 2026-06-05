package objeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Tarefa {


    private String nome, descricao;
    private final int id;
    private static int contador = 1;
    private Prioridade prioridade;
    private Status status;
    private Pessoa responsavel;

    public Tarefa(String nome, String descricao, Prioridade prioridade, Status status, Pessoa responsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.responsavel = responsavel;
        this.id = contador++;
    }

    public static Tarefa criar(Scanner scan, ArrayList<Pessoa> pessoas){

        System.out.println("Informe o nome da tarefa: ");
        String nome = scan.nextLine();

        System.out.println("Dê uma descrição mais detalhada sobre a tarefa: ");
        String descricao = scan.nextLine();

        System.out.println("Defina o nível de prioridade: 1- Baixa | 2- Média | 3- Alta | 4- Urgente");
        int prioridade = scan.nextInt();

        System.out.println("Informe o status atual: 1- Pendente | 2- Concluído");
        int status = scan.nextInt();

        System.out.println("\n--- Pessoas disponíveis ---");
        for (Pessoa p : pessoas) {
            System.out.println("ID: " + p.getId() + " - " + p.getNome());
        }
        System.out.println("----------------------------");

        System.out.println("Informe o ID da pessoa responsável:");
        int id_pessoa = scan.nextInt();
        Pessoa pessoaEscolhida = buscarPessoaPorId(pessoas, id_pessoa);

        if (pessoaEscolhida == null) {
            System.out.println("ID inválido! A tarefa será criada sem responsável.");
        }

        return new Tarefa(nome, descricao, Prioridade.pegaPrioridade(prioridade), Status.pegaStatus(status), pessoaEscolhida);
    }

    private static Pessoa buscarPessoaPorId(ArrayList<Pessoa> pessoas, int idPessoa) {

            for(Pessoa p : pessoas){
                if(p.getId() == idPessoa){
                    return p;
                }
            }
            return null;

    }

    public static ArrayList<Tarefa> filtrarPrioridade(ArrayList<Tarefa> tarefas, Prioridade prioridade){
        ArrayList<Tarefa> tarefasFiltradas = new ArrayList<>();
        for(Tarefa t : tarefas){
            if(t.getPrioridade() == prioridade){
                tarefasFiltradas.add(t);
            }
        }
        return tarefasFiltradas;
    }

    public static ArrayList<Tarefa> filtrarStatus(ArrayList<Tarefa> tarefas, Status status){
        ArrayList<Tarefa> tarefasFiltradas = new ArrayList<>();
        for(Tarefa t : tarefas){
            if(t.getStatus() == status){
                tarefasFiltradas.add(t);
            }
        }
        return tarefasFiltradas;
    }

    public static ArrayList<Tarefa> filtrarPessoa(ArrayList<Tarefa> tarefas, Pessoa pessoa){
        ArrayList<Tarefa> tarefasFiltradas = new ArrayList<>();
        for(Tarefa t : tarefas){
            if(t.getResponsavel() == pessoa){
                tarefasFiltradas.add(t);
            }
        }
        return tarefasFiltradas;
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

    public int getId() {
        return id;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public Pessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        String nomeResponsavel = (responsavel != null) ? responsavel.getNome() : "N/A";
        return "Id Tarefa: " + id + "\n" +
                " Nome da tarefa: " + nome + "\n" +
                " Descricao: " + descricao + "\n" +
                " Prioridade: " + prioridade.getDescricao() + "\n" +
                " Status: " + status.getDescricao() + "\n" +
                " Responsável: " + nomeResponsavel + "\n" + "\n";
    }
}

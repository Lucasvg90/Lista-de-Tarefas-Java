import objeto.Pessoa;
import objeto.Prioridade;
import objeto.Status;
import objeto.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Pessoa buscarPessoaPorId(ArrayList<Pessoa> pessoas, int id) {
        for (Pessoa p : pessoas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    private static Pessoa buscarPessoaPorNome(ArrayList<Pessoa> pessoas, String nome) {
        for (Pessoa p : pessoas) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Bem vindo ao TermTo-Do!\n");

        while (true) {
            System.out.println(
                    "Por favor, escolha sua ação!\n1 - Criar tarefa\n2 - Listar todas as tarefas\n3 - Filtrar tarefas\n4 - Adicionar Pessoas\n5 - Sair");
            int escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {
                case 1:
                    if (pessoas.isEmpty()) {
                        System.out.println(
                                "Atenção! Nenhuma pessoa cadastrada. Cadastre uma pessoa primeiro (opção 4).\n");
                        break;
                    }
                    System.out.println("-----Criar tarefa-----");

                    Tarefa novaTarefa = Tarefa.criar(scan, pessoas);

                    tarefas.add(novaTarefa);

                    System.out.println("Tarefa criada com sucesso!");

                    break;
                case 2:
                    System.out.println("-----Listar tarefas-----\n");
                    if (!(tarefas.isEmpty())) {
                        for (Tarefa t : tarefas) {
                            System.out.println(t.toString());
                        }
                    } else {
                        System.out.println("Ih, não tem nenhuma tarefa aqui não\n");
                    }
                    break;
                case 3:
                    System.out.println("-----Filtrar tarefas-----\n" +
                            "Informe o tipo de filtragem desejada:");

                    System.out.println("1 - Prioridade\n2 - Status\n3 - Pessoa");

                    int tipo = scan.nextInt();
                    scan.nextLine();

                    ArrayList<Tarefa> tarefasFiltradas = new ArrayList<>();

                    switch (tipo) {
                        case 1:
                            System.out.println(
                                    "Escolha a prioridade desejada: \n1 - Baixa\n2 - Média\n3 - Alta\n4 - Urgente");
                            int priori = scan.nextInt();
                            scan.nextLine();
                            tarefasFiltradas = Tarefa.filtrarPrioridade(tarefas, Prioridade.pegaPrioridade(priori));
                            break;

                        case 2:
                            System.out.println("Escolha o status: \n1 - Pendente\n2 - Concluído - \n3 - Atrasado");
                            int status = scan.nextInt();
                            tarefasFiltradas = Tarefa.filtrarStatus(tarefas, Status.pegaStatus(status));
                            break;

                        case 3:
                            System.out.println("--- Pessoas disponíveis ---");
                            for (Pessoa p : pessoas) {
                                System.out.println("ID: " + p.getId() + " - " + p.getNome());
                            }
                            System.out.println("----------------------------");
                            System.out.println("Informe o ID ou o Nome da pessoa:");
                            String entrada = scan.nextLine().trim();
                            Pessoa pessoaBuscada = null;
                            try {
                                int idPessoa = Integer.parseInt(entrada);
                                pessoaBuscada = buscarPessoaPorId(pessoas, idPessoa);
                            } catch (NumberFormatException e) {
                                pessoaBuscada = buscarPessoaPorNome(pessoas, entrada);
                            }
                            if (pessoaBuscada != null) {
                                tarefasFiltradas = Tarefa.filtrarPessoa(tarefas, pessoaBuscada);
                            } else {
                                System.out.println("Pessoa não encontrada.");
                            }
                            break;
                    }

                    if (tarefasFiltradas.isEmpty()) {
                        System.out.println("Nenhuma tarefa encontrada");
                    } else {
                        for (Tarefa t : tarefasFiltradas) {
                            System.out.println(t.toString());
                        }
                    }
                    break;

                case 4:
                    System.out.println("-----Adicionar Pessoa-----");
                    Pessoa novaPessoa = Pessoa.adicionar(scan);
                    pessoas.add(novaPessoa);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Tecla inválida, meu fi \nDigite novamente.");

            }

        }

    }
}

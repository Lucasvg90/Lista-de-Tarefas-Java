import objeto.Pessoa;
import objeto.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        ArrayList<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Bem vindo ao TermTo-Do!\n");

        while(true){
            System.out.println("Por favor, escolha sua ação!\n1 - Criar tarefa\n2 - Listar todas as tarefas\n3 - Filtrar tarefas\n4 - Adicionar Pessoas\n5 - Sair");
            int escolha = scan.nextInt();
            scan.nextLine();

            switch(escolha){
                case 1:
                    if(pessoas.isEmpty()){
                        System.out.println("Atenção! Nenhuma pessoa cadastrada. Cadastre uma pessoa primeiro (opção 4).\n");
                        break;
                    }
                    System.out.println("-----Criar tarefa-----");

                    Tarefa novaTarefa = Tarefa.criar(scan, pessoas);

                    tarefas.add(novaTarefa);

                    System.out.println("Tarefa criada com sucesso!");

                    break;
                case 2:
                    System.out.println("-----Listar tarefas-----\n");
                    if(!(tarefas.isEmpty())){
                    for(Tarefa t: tarefas){
                        System.out.println(t.toString());
                    }
                    } else {
                    System.out.println("Ih, não tem nenhuma tarefa aqui não\n");
                        }
                    break;
                case 3:
                    System.out.println("Filtrar tarefas");
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

import objeto.Tarefa;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        System.out.println("Bem vindo ao TermTo-Do!\n");

        while(true){
            System.out.println("Por favor, escolha sua ação!\n1 - Criar tarefa\n2 - Listar todas as tarefas\n3 - Filtrar tarefas\n4 - Sair");
            int escolha = scan.nextInt();
            scan.nextLine();
            switch(escolha){
                case 1:
                    System.out.println("-----Criar tarefa-----");

                    Tarefa novaTarefa = Tarefa.criar(scan);

                    tarefas.add(novaTarefa);

                    System.out.println("Tarefa criada com sucesso!");

                    break;
                case 2:
                    System.out.println("-----Listar tarefas-----\n");
                    for(Tarefa t: tarefas){
                        System.out.println(t.toString());
                    }
                    break;
                case 3:
                    System.out.println("Filtrar tarefas");
                    break;
                case 4:
                    System.out.println("Saindo...");
                    return;
            }


        }

    }


}

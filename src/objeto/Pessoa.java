package objeto;

import java.util.Scanner;

public class Pessoa {

    private String nome;
    private int id;
    private static int contador = 1;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = contador;
    }

    public static Pessoa adicionar(Scanner scan){
        System.out.println("Informe o nome da pessoa que deseja adicionar: ");
        String nome = scan.nextLine();
        return new Pessoa(nome, contador++);
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

package dominio;

import java.util.Scanner;
import colecao.IColecao;
import listaencadeada.ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IColecao<Personagem> lista = new ListaEncadeada<>();

        int opcao;
        do {
            System.out.println("\n========= MENU PERSONAGENS =========");
            System.out.println("1. Adicionar personagem");
            System.out.println("2. Remover personagem (por nome)");
            System.out.println("3. Pesquisar personagem (por nome)");
            System.out.println("4. Ver todos os personagens");
            System.out.println("5. Ver quantidade de nós");
            System.out.println("0. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Classe: ");
                    String classe = sc.nextLine();
                    System.out.print("Raça: ");
                    String raca = sc.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = sc.nextLine();

                    lista.adicionar(new Personagem(nome, classe, raca, sexo));
                    System.out.println("Personagem adicionado com sucesso!");
                }
                case 2 -> {
                    System.out.print("Digite o nome do personagem para remover: ");
                    String nome = sc.nextLine();
                    boolean removido = lista.remover(new Personagem(nome, "", "", ""));
                    if (removido) System.out.println("Personagem removido!");
                    else System.out.println("Não encontrado.");
                }
                case 3 -> {
                    System.out.print("Digite o nome para pesquisar: ");
                    String nome = sc.nextLine();
                    Personagem encontrado = lista.pesquisar(new Personagem(nome, "", "", ""));
                    if (encontrado != null) System.out.println("Encontrado: " + encontrado);
                    else System.out.println("Personagem não existe na lista.");
                }
                case 4 -> {
                    System.out.println("Lista Atual:");
                    System.out.println(lista.toString());
                }
                case 5 -> System.out.println("Total de elementos: " + lista.quantidadeNos());
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }
}
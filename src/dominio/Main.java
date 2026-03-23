package dominio;

import java.util.Scanner;

import colecao.IColecao;
import listaencadeada.*;

public class Main {
    public static void main(String[] args) {

        IColecao<Personagem> p;
        p = new ListaEncadeada<Personagem>();
        Personagem a;
        String nome, raca, classe, sexo;
        int resposta;
        Scanner scanner = new Scanner(System.in);




        try{
            do {
                System.out.println("Digite o nome do personagem");
                nome = scanner.nextLine();
                System.out.println("Digite a raça do personagem");
                raca = scanner.nextLine();
                System.out.println("Digite a classe do persongem");
                classe = scanner.nextLine();
                System.out.println("Digite o sexo do personagem");
                sexo = scanner.nextLine();
                a = new Personagem(nome, raca, classe, sexo);
                p.adicionar(a);
                System.out.println("Digite 1 para adicionar mais alunos ou outro numero para parar");
                resposta = scanner.nextInt();
                scanner.nextLine();
            } while(resposta == 1);
            scanner.close();
        } catch (Exception e){
            scanner.close();
            System.out.println("ERRO!" + e.getMessage());
        }


    }
}
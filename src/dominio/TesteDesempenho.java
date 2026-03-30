package dominio;

import colecao.IColecao;
import listaencadeada.*;
import java.io.File;
import java.util.Scanner;

public class TesteDesempenho {

    public static void main(String[] args) {
        String[] arquivos = {"personagens100k.txt", "personagens200k.txt", "personagens400k.txt"};

        System.out.println("Iniciando Testes de Desempenho (Tempo em Milissegundos)\n");
        System.out.printf("%-25s | %-10s | %-10s | %-10s%n", "Implementação", "100k", "200k", "400k");
        System.out.println("-----------------------------------------------------------------------");

        // Testar com a sua ListaEncadeada
        executarBateria("Sua Lista Encadeada", arquivos, () -> new ListaEncadeada<Personagem>());

        // Testar com o ArrayList encapsulado
        executarBateria("ArrayList Java", arquivos, () -> new ListaEncadeadaArrayList<Personagem>());

        // Testar com o LinkedList Java encapsulado
        executarBateria("LinkedList Java", arquivos, () -> new ListaEncadeadaLinkedList<Personagem>());
    }

    private static void executarBateria(String nomeTeste, String[] arquivos, java.util.function.Supplier<IColecao<Personagem>> fabricaLista) {
        System.out.printf("%-25s", nomeTeste);

        for (String arq : arquivos) {
            IColecao<Personagem> lista = fabricaLista.get();
            long tempo = medirTempoCarregamento(arq, lista);
            System.out.printf(" | %-10d", tempo);
        }
        System.out.println();
    }

    private static long medirTempoCarregamento(String caminho, IColecao<Personagem> lista) {
        File file = new File(caminho);
        if (!file.exists()) return -1; // Arquivo não gerado ainda

        long inicio = System.currentTimeMillis();
        try (Scanner leitor = new Scanner(file)) {
            while (leitor.hasNextLine()) {
                String[] partes = leitor.nextLine().split(";");
                if (partes.length == 4) {
                    lista.adicionar(new Personagem(partes[0], partes[1], partes[2], partes[3]));
                }
            }
        } catch (Exception e) {
            return -2;
        }
        return System.currentTimeMillis() - inicio;
    }
}
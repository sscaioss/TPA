package util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorArquivosPersonagem {

    private static String[] nomesMasculinos = {
            "Gabriel", "Lucas", "Rafael", "Mateus",
            "Pedro", "Arthur", "Joao", "Daniel",
            "Gustavo", "Bruno", "Felipe", "Henrique",
            "Eduardo", "Victor", "Leonardo", "Caio",
            "Diego", "Igor", "Rodrigo", "Thiago"
    };

    private static String[] nomesFemininos = {
            "Maria", "Ana", "Julia", "Beatriz",
            "Larissa", "Camila", "Fernanda", "Amanda",
            "Carolina", "Patricia", "Leticia", "Isabela",
            "Mariana", "Gabriela", "Juliana", "Bruna",
            "Renata", "Vanessa", "Natasha", "Helena"
    };

    private static String[] classes = {
            "Guerreiro", "Arqueiro", "Mago",
            "Ladino", "Paladino", "Curandeiro",
            "Necromante", "Bardo"
    };

    private static String[] racas = {
            "Humano", "Elfo", "Anao",
            "Orc", "Goblin", "Draconato"
    };

    private static String[] sexos = {
            "Masculino",
            "Feminino"
    };

    public static void gerarArquivo(
            String nomeArquivo,
            int quantidade
    ) throws IOException {

        FileWriter writer = new FileWriter(nomeArquivo);

        Random random = new Random();

        for (int i = 0; i < quantidade; i++) {

            // Primeiro define o sexo
            String sexo = sexos[random.nextInt(sexos.length)];

            String nome;

            // Agora escolhe o nome compatível
            if (sexo.equals("Masculino")) {
                nome = nomesMasculinos[random.nextInt(nomesMasculinos.length)] + i;
            }
            else {
                nome = nomesFemininos[random.nextInt(nomesFemininos.length)] + i;
            }

            String classe = classes[random.nextInt(classes.length)];
            String raca = racas[random.nextInt(racas.length)];

            writer.write(
                    nome + ";" +
                            classe + ";" +
                            raca + ";" +
                            sexo + "\n"
            );
        }
        writer.close();

        System.out.println(
                "Arquivo " +
                        nomeArquivo +
                        " gerado com " +
                        quantidade +
                        " registros."
        );
    }

    public static void main(String[] args)
            throws IOException {

        gerarArquivo(
                "personagens100k.txt",
                100000
        );

        gerarArquivo(
                "personagens200k.txt",
                200000
        );

        gerarArquivo(
                "personagens400k.txt",
                400000
        );

    }
}
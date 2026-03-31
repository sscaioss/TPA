# 🛡️ TPA Project

Este repositório contém o desenvolvimento de uma biblioteca de estruturas de dados genéricas, focada em **Listas Encadeadas**, e um estudo comparativo de performance entre implementações manuais e nativas da Java Collections Framework.

## 🎯 Objetivos Técnicos
1.  **Abstração e Polimorfismo**: Implementação de uma interface comum (`IColecao`) para garantir o desacoplamento entre a lógica de negócio e a estrutura de armazenamento.
2.  **Gerenciamento de Memória**: Estudo da alocação de nós dinâmicos vs. arrays estáticos redimensionáveis.
3.  **Análise de Algoritmos**: Validação empírica das ordens de complexidade (Big O) para operações de inserção e busca em larga escala.

---

## 🏗️ Funcionamento Interno das Estruturas

### 1. Lista Encadeada (Manual)
Diferente de um array, a nossa `ListaEncadeada` não aloca um bloco contíguo de memória. Cada elemento é um `No<T>` independente.
* **Vantagem**: Inserção no início ou fim é $O(1)$ pois exige apenas a troca de ponteiros.
* **Desvantagem**: Para acessar o 100º elemento, o processador deve percorrer os 99 anteriores (acesso sequencial).



### 2. ArrayList (Nativo Java)
Utiliza um **Array** interno. Quando ele enche, o Java cria um novo array maior e copia todos os elementos.
* **Vantagem**: Localidade de referência. Como os dados estão vizinhos na memória RAM, o cache do processador trabalha de forma muito mais eficiente.
* **Desvantagem**: Inserções no início ou meio exigem o deslocamento de todos os elementos subsequentes ($O(n)$).

### 3. LinkedList (Nativo Java)
É uma lista duplamente encadeada. Cada nó aponta para o próximo e para o anterior.
* **Observação**: Embora seja flexível, ela cria muitos objetos pequenos, o que pode causar pressão no *Garbage Collector* em volumes massivos de dados.

---

## ⏱️ Metodologia de Benchmark (Teste de Carga)

O teste foi desenhado para simular um cenário real de "Data Loading". Utilizamos arquivos de texto (`.txt`) simulando um banco de dados de personagens de RPG.

### Resultados Coletados (Tempo de Processamento)

Exemplo de teste em um dos computadores

| Implementação | 100.000 (100k) | 200.000 (200k) | 400.000 (400k) |
| :--- | :--- | :--- | :--- |
| **Lista Encadeada Manual** | 275 ms | 215 ms | 438 ms |
| **ArrayList (Java)** | 148 ms | 99 ms | 188 ms |
| **LinkedList (Java)** | 47 ms | 89 ms | 348 ms |

### 🔍 Conclusões da Análise
* **Predomínio do ArrayList**: Em operações de escrita no final (append), o ArrayList vence por não precisar instanciar um novo objeto `No` a cada inserção, apenas preencher uma posição de memória já alocada.
* **Custo de Instanciação**: A `Lista Encadeada Manual` e a `LinkedList` do Java sofrem com o *overhead* de criação de milhares de objetos `No`, o que explica o tempo superior.
* **Eficiência de Cache**: O ArrayList aproveita melhor a arquitetura de hardware moderna, resultando em tempos menores mesmo com o crescimento da entrada.

---

## 🚀 Como Executar o Projeto

Siga o passo a passo abaixo para configurar o ambiente e rodar os testes, seja no **IntelliJ IDEA** ou no **VS Code**.

### 1. Clonar o Repositório
Abra o seu terminal e escolha uma das opções de protocolo:

* **Via HTTPS (Mais simples):**
    ```bash
    git clone [https://github.com/sscaioss/TPA.git](https://github.com/sscaioss/TPA.git)
    ```
* **Via SSH (Recomendado se tiver chaves configuradas):**
    ```bash
    git clone git@github.com:sscaioss/TPA.git
    ```

---

### 2. Configuração na IDE

#### No IntelliJ IDEA:
1.  Vá em `File > Open` e selecione a pasta `TPA`.
2.  Certifique-se de que o **JDK 17** (ou superior) está selecionado em `File > Project Structure`.
3.  O IntelliJ deve reconhecer a pasta `src` automaticamente. Caso as classes fiquem com um ícone vermelho, clique com o botão direito na pasta `src` e selecione **Mark Directory as > Sources Root**.

#### No VS Code:
1.  Certifique-se de ter o **Extension Pack for Java** instalado.
2.  Abra a pasta do projeto. O VS Code detectará os arquivos `.java` e habilitará os botões de "Run" acima dos métodos `main`.

---

### 3. Ordem de Execução dos Testes

Para que o projeto funcione corretamente, siga esta sequência:

#### **Passo 1: Gerar a Massa de Dados**
Os arquivos de texto com milhares de registros não são processados sem antes serem criados localmente.
* Abra e execute a classe: `src/util/GeradorArquivosPersonagem.java`.
* Isso criará os arquivos `personagens100k.txt`, `personagens200k.txt` e `personagens400k.txt` na raiz do seu projeto.

#### **Passo 2: Rodar o Benchmark (Análise de Tempo)**
Para comparar a performance entre a nossa Lista Encadeada e as listas do Java:
* Abra e execute a classe: `src/dominio/TesteDesempenho.java`.
* O console exibirá uma tabela com os tempos de execução em milissegundos (**ms**).

#### **Passo 3: Rodar o Sistema Principal (Terminal)**
Para interagir manualmente com a estrutura (adicionar, remover e pesquisar personagens):
* Abra e execute a classe: `src/dominio/Main.java`.
* Utilize o menu numérico no console para realizar as operações.

---


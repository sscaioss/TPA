package listaencadeada;

import java.util.LinkedList;
import colecao.IColecao;

public class ListaEncadeadaLinkedList<T> implements IColecao<T> {
    private final LinkedList<T> listaInterna = new LinkedList<>();

    @Override
    public void adicionar(T novoValor) {
        listaInterna.add(novoValor);
    }

    @Override
    public T pesquisar(T valor) {
        int index = listaInterna.indexOf(valor);
        return (index != -1) ? listaInterna.get(index) : null;
    }

    @Override
    public boolean remover(T valor) {
        return listaInterna.remove(valor);
    }

    @Override
    public int quantidadeNos() {
        return listaInterna.size();
    }

}
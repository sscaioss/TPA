package listaencadeada;

import java.util.ArrayList;
import colecao.IColecao;

public class ListaEncadeadaArrayList<T> implements IColecao<T> {
    private final ArrayList<T> listaInterna = new ArrayList<>();

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

    @Override
    public void limpar() {
        listaInterna.clear();
    }
}
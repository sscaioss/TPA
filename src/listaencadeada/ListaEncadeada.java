package listaencadeada;

import colecao.IColecao;

public class ListaEncadeada<T> implements IColecao<T>{
    private No<T> prim;
    private No<T> ult;
    private int quant;

    public ListaEncadeada() {
        this.prim = null;
        this.ult = null;
        this.quant = 0;
    }


    @Override
    public void adicionar(T novoValor) {
        No<T> novo = new No<>(novoValor);

        if(this.prim == null) {
            this.prim = novo;
            this.ult = novo;
        }

        else {
            this.ult.setProx(novo);
            this.ult = novo;
        }
        this.quant++;
    }

    @Override
    public T pesquisar(T valor) {
        No<T> aux =  this.prim;

        while (aux != null) {
            if (aux.getValor().equals(valor)) {
                return aux.getValor();
            }
            aux = aux.getProx();
        }
        return null;
    }

    @Override
    public boolean remover(T valor) {
        No<T> aux = this.prim;
        No<T> ant = null;

        while (aux != null) {
            if (aux.getValor().equals(valor)) {

                if (aux == this.prim) {
                    this.prim = this.prim.getProx();
                    if (aux == this.ult) {
                        this.ult = null;
                    }
                }
                else {
                    ant.setProx((aux).getProx());
                    if (aux == this.ult) {
                        this.ult = ant;
                    }
                }

                this.quant--;
                return true;
            }
            ant = aux;
            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public int quantidadeNos() {
        return this.quant;
    }

    public String toString() {
        No<T> aux = this.prim;
        StringBuffer sb = new StringBuffer("[");

        while (aux != null) {
            sb.append(aux.getValor().toString());
            if (aux != this.ult) {
                sb.append(", ");
            }
            aux = aux.getProx();
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean estaVazia() {
        return this.prim == null;
    }

    public T primeiro() {
        return this.prim != null ? this.prim.getValor() : null;
    }

    public T ultimo() {
        return this.ult != null ? this.ult.getValor() : null;
    }
}

package projeto;

import java.io.BufferedWriter;
import java.io.IOException;

public class ABB {
    private class Nodo {
        String palavra;
        ListaEncadeada linhas;
        Nodo esquerda, direita;

        Nodo(String palavra, int linha) {
            this.palavra = palavra;
            this.linhas = new ListaEncadeada();
            this.linhas.inserir(linha);
        }
    }

    private Nodo raiz;

    public void inserir(String palavra, int linha) {
        raiz = inserir(raiz, palavra, linha);
    }

    private Nodo inserir(Nodo nodo, String palavra, int linha) {
        if (nodo == null) return new Nodo(palavra, linha);
        int cmp = palavra.compareTo(nodo.palavra);
        if (cmp < 0) nodo.esquerda = inserir(nodo.esquerda, palavra, linha);
        else if (cmp > 0) nodo.direita = inserir(nodo.direita, palavra, linha);
        else nodo.linhas.inserir(linha);
        return nodo;
    }

    public void imprimirOrdenado(BufferedWriter writer) throws IOException {
        imprimirOrdenado(raiz, writer);
    }

    private void imprimirOrdenado(Nodo nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            imprimirOrdenado(nodo.esquerda, writer);
            writer.write(nodo.palavra + " " + nodo.linhas.toString());
            writer.newLine();
            imprimirOrdenado(nodo.direita, writer);
        }
    }
}

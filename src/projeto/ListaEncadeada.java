package projeto;

public class ListaEncadeada {
    private class Nodo {
        int linha;
        Nodo proximo;

        Nodo(int linha) {
            this.linha = linha;
        }
    }

    private Nodo inicio;

    public void inserir(int linha) {
        if (inicio == null) {
            inicio = new Nodo(linha);
        } else {
            Nodo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = new Nodo(linha);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo atual = inicio;
        while (atual != null) {
            sb.append(atual.linha).append(" ");
            atual = atual.proximo;
        }
        return sb.toString().trim();
    }
}

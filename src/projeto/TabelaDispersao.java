package projeto;
import java.util.HashMap;

public class TabelaDispersao {
    private HashMap<String, ListaEncadeada> tabela;

    public TabelaDispersao() {
        tabela = new HashMap<>();
    }

    public void inserir(String palavra, int linha) {
        tabela.computeIfAbsent(palavra, k -> new ListaEncadeada()).inserir(linha);
    }

    public ListaEncadeada buscar(String palavra) {
        return tabela.get(palavra);
    }
}


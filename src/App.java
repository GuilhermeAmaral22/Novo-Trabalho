import projeto.*;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Uso: java App <arquivo-palavras-chave> <arquivo-texto> <arquivo-saida>");
            return;
        }

        String arquivoPalavrasChave = args[0];
        String arquivoTexto = args[1];
        String arquivoSaida = args[2];

        try {
            List<String> palavrasChave = LeitorArquivos.lerArquivo(arquivoPalavrasChave);
            List<String> texto = LeitorArquivos.lerArquivo(arquivoTexto);

            TabelaDispersao tabelaHash = new TabelaDispersao();
            ABB arvore = new ABB();

            int linhaNumero = 1;
            for (String linha : texto) {
                String[] palavras = linha.split("\\W+");
                for (String palavra : palavras) {
                    if (palavrasChave.contains(palavra)) {
                        tabelaHash.inserir(palavra, linhaNumero);
                        arvore.inserir(palavra, linhaNumero);
                    }
                }
                linhaNumero++;
            }

            GeradorIndiceRemissivo.gerarArquivo(arquivoSaida, arvore);
            System.out.println("Índice remissivo gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

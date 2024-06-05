package projeto;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class GeradorIndiceRemissivo {
    public static void gerarArquivo(String caminho, ABB arvore) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            arvore.imprimirOrdenado(writer);
        }
    }
}


package projeto;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class LeitorArquivos {
    public static List<String> lerArquivo(String caminho) throws IOException {
        return Files.readAllLines(Paths.get(caminho));
    }
}

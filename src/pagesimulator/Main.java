package pagesimulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path diretorio = Paths.get(args[0]);

        if (!Files.isDirectory(diretorio)) {
            System.err.println("O caminho informado nao e um diretorio valido.");
            return;
        }

        try {
            Files.list(diretorio).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro ao ler o diretorio: " + e.getMessage());
        }
    }
}

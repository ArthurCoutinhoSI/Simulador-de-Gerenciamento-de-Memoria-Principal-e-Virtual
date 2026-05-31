package diretorio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

import vigesissexagesimal.Vigesissexagesimal;

public class DiretorioService {
    private static Vigesissexagesimal conteudo; // classe responsável por gerar conteúdo único para cada página, garantindo que cada arquivo tenha um conteúdo distinto

    public static void preencherDiretorio(Path diretorio, int numeroPaginasUnicas) {
        conteudo = new Vigesissexagesimal(); // inicializa a instância para começar a gerar conteúdo único

        try {
            criarDiretorio(diretorio);
            for (int i = 0; i < numeroPaginasUnicas; i++) {
                // System.out.println(diretorio + " preencherDiretorio " + numeroPaginasUnicas);

                criarArquivo(diretorio.resolve(i + ".pag"), conteudo.toString());
                conteudo.incrementa();
            }
        } catch (IOException e) {
            System.err.println("Erro ao preencher diretório: " + e.getMessage());
        }
    }

    private static void criarDiretorio(Path caminho) throws IOException {
        if (Files.exists(caminho)) {
            if (Files.isDirectory(caminho)) {
                Files.walk(caminho)
                        .sorted(Comparator.reverseOrder()) // garante que arquivos sejam deletados antes dos diretórios pra não dar erro
                        .forEach(path -> {
                            try {
                                Files.deleteIfExists(path);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
            } else {
                Files.deleteIfExists(caminho);
            }
        }
        Files.createDirectories(caminho);
    }

    private static void criarArquivo(Path caminho, String conteudo) throws IOException {
        if (Files.exists(caminho)) {
            Files.delete(caminho);
        }
        Files.createFile(caminho);
        Files.write(caminho, conteudo.getBytes());
    }
}
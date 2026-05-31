package diretorio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import vigesissexagesimal.Vigesissexagesimal;

public class DiretorioService {
    private static Vigesissexagesimal conteudo; // classe responsável por gerar conteúdo único para cada página, garantindo que cada arquivo tenha um conteúdo distinto

    public static void preencherDiretorio(Path diretorio, int numeroPaginasUnicas) {
        conteudo = new Vigesissexagesimal(); // inicializa a instância para começar a gerar conteúdo único

        try {
            criarDiretorio(diretorio);
            for (int i = 0; i < numeroPaginasUnicas; i++) {

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
                Files.walkFileTree(caminho, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        if (!dir.equals(caminho)) {
                            Files.delete(dir);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                });
            } else {
                Files.delete(caminho);
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
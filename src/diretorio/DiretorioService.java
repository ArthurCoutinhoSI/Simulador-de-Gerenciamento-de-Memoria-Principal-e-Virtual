package diretorio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import vigesissexagesimal.Vigesissexagesimal;

public class DiretorioService {
    private DiretorioService() {
        /* This utility class should not be instantiated */
    }

    public static char[] buscarPaginaNoDiretorio(Path diretorio, int pagina) {
        Path arquivoPagina = diretorio.resolve(pagina + ".pag");
        if (Files.exists(arquivoPagina)) {
            try {
                return Files.readAllBytes(arquivoPagina).toString().toCharArray();
            } catch (IOException e) {
                System.err.println("Erro ao ler página do diretório: " + e.getMessage());
                return new char[10]; // Retorna um array vazio em caso de erro
            }
        }
        return new char[10]; // Retorna um array vazio se a página não for encontrada
    }

    public static void preencheMemoriaPrincipal(Path diretorio, int quantidadePaginas) {
        Vigesissexagesimal conteudo; 
        conteudo = new Vigesissexagesimal(); // inicializa a instância para começar a gerar conteúdo único

        try {
            criarDiretorio(diretorio);
            for (int i = 0; i < quantidadePaginas; i++) {

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
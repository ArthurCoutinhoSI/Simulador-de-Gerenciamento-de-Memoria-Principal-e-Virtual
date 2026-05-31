package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;

import diretorio.DiretorioService;

public class Main {
    public static void main(String[] args) {
        Path diretorio = Paths.get(args[0]);
        int quantidadePaginasUnicas = Integer.parseInt(args[1]);
        // System.out.println("MAIN " + diretorio + " " + quantidadePaginasUnicas);

        DiretorioService.preencherDiretorio(diretorio, quantidadePaginasUnicas); // preenche o diretório com 100 páginas únicas
    }
}

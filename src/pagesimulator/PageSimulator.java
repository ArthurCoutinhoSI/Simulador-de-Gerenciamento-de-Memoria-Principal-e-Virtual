package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import diretorio.DiretorioService;
import memoriaprincipal.MemoriaPrincipal;
import memoriavirtual.MemoriaVirtual;

public class PageSimulator {
    public static void main(String[] args) {
        Path diretorio = Paths.get(args[0]);
        String estrategia = args[1];
        int quantidadeFramesMemoria = Integer.parseInt(args[2]);
        int quantidadePaginasUnicas = Integer.parseInt(args[3]);
        int quantidadePaginasRequeridas = Integer.parseInt(args[4]);

        MemoriaPrincipal memoriaPrincipal = new MemoriaPrincipal(quantidadeFramesMemoria);
        MemoriaVirtual memoriaVirtual = new MemoriaVirtual(quantidadePaginasUnicas);

        DiretorioService.preencheMemoriaPrincipal(diretorio, memoriaVirtual.getPaginas()); // preenche o diretório simulando memoria principal

        while (quantidadePaginasRequeridas > 0) {
            // lógica para simular o acesso às páginas, utilizando a estratégia de substituição escolhida
            // e atualizando a memória principal e virtual conforme necessário
            // isso pode incluir a leitura de arquivos de página, a atualização do diretório, etc


            // System.out.println("Simulando acesso às páginas... (a lógica de acesso e substituição deve ser implementada aqui)");
            // System.out.println("Estratégia de substituição: " + estrategia);
            // System.out.println("Memória Principal:");
            // for (int i = 0; i < memoriaPrincipal.getFrames().length; i++) {
            //     System.out.println("Frame " + i + ": " + new String(memoriaPrincipal.getFrames()[i]));
            // }
            // System.out.println("Memória Virtual:");
            // for (int i = 0; i < memoriaVirtual.getPaginas().length; i++) {
            //     System.out.println("Página " + i + ": " + new String(memoriaVirtual.getPaginas()[i]));
            // }


            quantidadePaginasRequeridas--;
        }
    }
}

package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import diretorio.DiretorioService;
import memoriaprincipal.MemoriaPrincipal;
import memoriavirtual.MemoriaVirtual;
import pagetable.PageTable;

public class PageSimulator {
    public static void main(String[] args) {
        Path diretorio = Paths.get(args[0]);
        String estrategia = args[1];
        int quantidadeFramesMemoria = Integer.parseInt(args[2]);
        int quantidadePaginasUnicas = Integer.parseInt(args[3]);
        int quantidadePaginasRequeridas = Integer.parseInt(args[4]);

        Scanner scanner = new Scanner(System.in);

        MemoriaPrincipal memoriaPrincipal = new MemoriaPrincipal(quantidadeFramesMemoria);
        MemoriaVirtual memoriaVirtual = new MemoriaVirtual(quantidadePaginasUnicas);
        PageTable pageTable = new PageTable(memoriaPrincipal.getFrames().length); 

        DiretorioService.preencheMemoriaPrincipal(diretorio, memoriaVirtual.getPaginas()); // preenche o diretório simulando memoria principal

        while (quantidadePaginasRequeridas > 0) {
            // lógica para simular o acesso às páginas, utilizando a estratégia de substituição escolhida
            // e atualizando a memória principal e virtual conforme necessário
            // isso pode incluir a leitura de arquivos de página, a atualização do diretório, etc
            
            int paginasRequeridas = scanner.nextInt(); // aguarda o usuário pressionar Enter para simular o próximo acesso à página
            
            // 1. Encontre o local da página desejada no disco
            int paginaEncontrada = DiretorioService.buscarPaginaNoDiretorio(diretorio, paginasRequeridas);

            // 2 Se há um frame livre, use-o    
            // 3 Se não há frame livre
            // - Use um algoritmo de substituição de página para selecionar um
            //      frame vítima
            // - Escreva o frame vítima no disco e altere as tabelas de frame
            //      apropriadamente
            // 4 Carregue a página desejada no frame livre e altere as tabelas
            // de frame e de página apropriadamente

            quantidadePaginasRequeridas--;
        }
    }
}

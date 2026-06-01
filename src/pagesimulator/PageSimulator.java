package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.SubstituidorPagina;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import memoriaprincipal.MemoriaPrincipal;
import memoriavirtual.MemoriaVirtual;
import pagetable.PageTable;
import relatorio.Relatorio;

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

        SubstituidorPagina substituidor = new SubstituidorPagina(null);
        switch (estrategia.toLowerCase()) {
            case "fifo":
                substituidor.setEstrategia(new EstrategiaFifo(pageTable.getFrames()));
                break;
            // outros casos para diferentes estratégias de substituição de página podem ser adicionados aqui
            default:
                System.out.println("Estratégia de substituição de página desconhecida. Usando FIFO por padrão.");
                substituidor.setEstrategia(new EstrategiaFifo(pageTable.getFrames()));
                break;
        }

        while (quantidadePaginasRequeridas > 0) {
            // lógica para simular o acesso às páginas, utilizando a estratégia de substituição escolhida
            // e atualizando a memória principal e virtual conforme necessário
            // isso pode incluir a leitura de arquivos de página, a atualização do diretório, etc

            int paginasRequeridas = scanner.nextInt(); // aguarda o usuário pressionar Enter para simular o próximo acesso à página
            
            

            quantidadePaginasRequeridas--;
        }
    }
}

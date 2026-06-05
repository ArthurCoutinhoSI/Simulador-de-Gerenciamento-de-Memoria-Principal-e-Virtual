package gerenciadormemoria;

import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import memoriaprincipal.MemoriaPrincipal;
import pagetable.PageTable;

public class GerenciadorMemoria {
    // Estado do sistema (contexto do strategy)
    private MemoriaPrincipal memoriaPrincipal;
    private PageTable pageTable;
    private EstrategiaSubstituicaoPagina estrategia;

    private Scanner scanner;

    public GerenciadorMemoria(String estrategia, int qtdFrames, int paginasUnicas, String diretorio) {
        this.strategyBuilder(estrategia);
        this.memoriaPrincipal = new MemoriaPrincipal(qtdFrames);
        this.pageTable = new PageTable(paginasUnicas);
        DiretorioService.inicializarArquivosEmDisco(diretorio, paginasUnicas);
        
        this.scanner = new Scanner(System.in);
    }

    private void strategyBuilder(String estrategiaString) {
        switch (estrategiaString.toLowerCase()) {
            case "fifo":
                this.estrategia = new EstrategiaFifo();
                break;
            // outros casos para diferentes estratégias de substituição de página podem ser adicionados aqui
            default:
                System.out.println("Estratégia de substituição de página desconhecida. Usando FIFO por padrão.");
                this.estrategia = new EstrategiaFifo();
                break;
        }
    }

    public void executarSimulacao(int n){
        while (n > 0){
            int paginaRequerida = scanner.nextInt();

            System.out.println("Página Requerida: " + paginaRequerida);

            if(pageTable.getFrameByIndex(paginaRequerida) != -1){
                simulaAcesso();
                System.out.println(pageTable.toString());
                continue;
            }

            int indexDoFrameLivre = memoriaPrincipal.getIndexOfFrameLivre();

            if(indexDoFrameLivre != -1){ //significa que ta memoriaprincipal não ta cheia
                carregaPaginaNaMemoriaPrincipal(indexDoFrameLivre, paginaRequerida);
            }else{
                substituiPaginaNaMemoriaPrincipal(indexDoFrameLivre, paginaRequerida);
            }


            System.out.println(pageTable.toString());

            n -= 1;
        }
    }

    private void simulaAcesso(){
    }

    private void carregaPaginaNaMemoriaPrincipal(int indexDoFrameLivre, int paginaRequerida){
        estrategia.add(indexDoFrameLivre);
        pageTable.add(paginaRequerida, indexDoFrameLivre);
        memoriaPrincipal.inserePaginaNaMemoria(paginaRequerida, indexDoFrameLivre);
    }

    private void substituiPaginaNaMemoriaPrincipal(int indexDoFrameLivre, int paginaRequerida){
        indexDoFrameLivre = estrategia.remove();
        pageTable.softRemoveByFrame(indexDoFrameLivre);
        memoriaPrincipal.removePaginaDaMemoriaPorFrame(indexDoFrameLivre);

        // aqui escreveria de volta oq esta na memoria para o disco/memoria virtual

        carregaPaginaNaMemoriaPrincipal(indexDoFrameLivre, paginaRequerida);
        
    }
}

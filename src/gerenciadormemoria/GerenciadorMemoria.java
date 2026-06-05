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

            if(pageTable.findIndexOfFrame(paginaRequerida) != -1){
                // acesso foi feito com sucesso
                continue;
            }

            int indexDoFrameLivre = memoriaPrincipal.getIndexOfFrameLivre();

            if(indexDoFrameLivre == -1){ //significa que ta cheio
                int indexDoFrameremovido = pageTable.softRemove(estrategia.remove());
            }

            estrategia.add(indexDoFrameLivre);
            pageTable.add(paginaRequerida, indexDoFrameLivre);

            System.out.println(this.toString());
            System.out.println(n);

            n -= 1;
        }
    }

    @Override
    public String toString(){
        return "GerenciadorMemoria{" +
                "memoriaRAM=" + memoriaPrincipal.getMemoriaPrincipal().length + " frames" +
                ", pageTable=" + pageTable +
                ", estrategia=" + estrategia +
                '}';
    }
}

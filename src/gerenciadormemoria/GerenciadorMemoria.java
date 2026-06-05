package gerenciadormemoria;

import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import pagetable.PageTable;

public class GerenciadorMemoria {
    // Estado do sistema (O Contexto é dono disso)
    private char[][] memoriaRAM;
    private PageTable pageTable;
    private EstrategiaSubstituicaoPagina estrategia;

    public GerenciadorMemoria(String estrategia, int qtdFrames, int paginasUnicas, String diretorio) {
        this.strategyBuilder(estrategia);
        this.memoriaRAM = new char[qtdFrames][10];
        this.pageTable = new PageTable(paginasUnicas);
        DiretorioService.inicializarArquivosEmDisco(diretorio, paginasUnicas);
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
        
    }
}

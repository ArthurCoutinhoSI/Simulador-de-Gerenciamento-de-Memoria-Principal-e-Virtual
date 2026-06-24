package gerenciadormemoria;

import java.util.ArrayList;
import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import estrategiassubstituicaopaginas.estrategias.EstrategiaLru;
import estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem.EstrategiaLfu;
import estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem.EstrategiaMfu;
import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import memoriaprincipal.MemoriaPrincipal;
import pagetable.PageTable;

public class GerenciadorMemoria {
    // estado do sistema (contexto do strategy)
    private MemoriaPrincipal memoriaPrincipal;
    private PageTable pageTable;
    private int qtdPaginasUnicas;
    private EstrategiaSubstituicaoPagina estrategia;

    private int contaFalhasDePagina = 0;
    private ArrayList<Integer> sequenciaDeRequisicaoDePaginas = new ArrayList<>();

    private Scanner scanner;

    public GerenciadorMemoria(String estrategia, int qtdFrames, int paginasUnicas, String diretorio) {
        this.strategyBuilder(estrategia);
        this.memoriaPrincipal = new MemoriaPrincipal(qtdFrames);
        this.pageTable = new PageTable(paginasUnicas);
        this.qtdPaginasUnicas = paginasUnicas;
        DiretorioService.inicializarArquivosEmDisco(diretorio, paginasUnicas);
        
        this.scanner = new Scanner(System.in);
    }

    private void strategyBuilder(String estrategiaString) {
        estrategiaString = estrategiaString.toUpperCase();
        switch (estrategiaString) {
            case "FIFO":
                this.estrategia = new EstrategiaFifo();
                System.out.println("Estratégia Selecionada: FIFO.");
                break;
            case "LRU":
                this.estrategia = new EstrategiaLru();
                System.out.println("Estratégia Selecionada: LRU.");
                break;
            case "LFU":
                this.estrategia = new EstrategiaLfu();
                System.out.println("Estratégia Selecionada: LFU.");
                break;
            case "MFU":
                this.estrategia = new EstrategiaMfu();
                System.out.println("Estratégia Selecionada: MFU.");
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

            // faz o tratamento de erro na mão msm
            if(paginaRequerida < 0 || paginaRequerida > qtdPaginasUnicas) {
                System.err.println("Não é possível acessar pagina fora dos limites 0 e " + qtdPaginasUnicas);
                continue;
            }

            this.sequenciaDeRequisicaoDePaginas.addLast(paginaRequerida);

            System.out.println("Página Requerida: " + paginaRequerida);

            // simula acesso caso pagina já esteja carregada na memória principal
            if(pageTable.getFrameByIndex(paginaRequerida) != -1){
                simulaAcesso(paginaRequerida);
                System.out.println(this.relatorioDoAcessoUnico());
                continue;
            }

            int indexDoFrameLivre = memoriaPrincipal.getIndexOfFrameLivre();

            if(indexDoFrameLivre != -1){ //significa que ta memoriaprincipal não ta cheia
                carregaPaginaNaMemoriaPrincipal(indexDoFrameLivre, paginaRequerida);
                simulaAcesso(paginaRequerida);
            }else{
                this.contaFalhasDePagina++;
                substituiPaginaNaMemoriaPrincipal(indexDoFrameLivre, paginaRequerida);
                simulaAcesso(paginaRequerida);
            }


            System.out.println(this.relatorioDoAcessoUnico());

            n -= 1;
        }
        System.out.println(relatorioFinal());
    }

    private void simulaAcesso(int paginaRequerida){
        int frame = pageTable.getFrameByIndex(paginaRequerida);
        estrategia.acessa(frame);
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

    private String relatorioDoAcessoUnico(){
        StringBuilder sb = new StringBuilder();

		sb.append("Frame\t\tPágina\t\tConteúdo\n");
		for (int i = 0; i < memoriaPrincipal.getMemoriaPrincipal().length; i++) {
            sb.append(i);
            sb.append("\t\t");
            sb.append(pageTable.findIndexOfFrame(i));
            sb.append("\t\t");
            sb.append(memoriaPrincipal.getMemoriaPrincipal()[i]);
            sb.append("\n");
		}
		
		return sb.toString();
    }

    private String relatorioFinal() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algoritmo de Substituição de Páginas: ");
        sb.append(estrategia.getNome());
        sb.append("\n");
        sb.append("Sequência de Requisição: ");
        sb.append(sequenciaDeRequisicaoDePaginas.toString());
        sb.append("\n");
        sb.append("Total de Falhas de Página: ");
        sb.append(contaFalhasDePagina);
        sb.append("\n");
        

        return sb.toString();
    }
}

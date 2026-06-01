package estrategiassubstituicaopaginas.estrategias;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    private int[] fila;
    private int indice;

    public EstrategiaFifo(int[] framesPageTable) {
        this.fila = framesPageTable; // a fila é inicializada com os frames da tabela de páginas
        this.indice = 0;
    }   

    // nesse caso, a o metodo substitui ou adiciona a pagina no frame livre, e retorna a pagina que foi substituida, caso haja necessidade de substituição
    @Override
    public int substituirPagina(int pagina, int frame) {
        fila[indice] = pagina; // armazena a página que está sendo carregada no frame
        indice = (indice + 1) % fila.length; // move o índice para o próximo frame, voltando ao início se necessário
        return fila[(indice - 1 + fila.length) % fila.length]; // retorna a página que foi substituída
    }
}

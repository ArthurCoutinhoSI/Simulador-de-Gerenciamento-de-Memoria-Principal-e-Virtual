package estrategiassubstituicaopaginas.estrategias;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    private int[] fila;
    private int indice;

    public EstrategiaFifo(int tamanho) {
        this.fila = new int[tamanho];
        this.indice = 0;
    }

    @Override
    public void substituirPagina(int pagina, int frame) {
        fila[indice] = pagina; // armazena a página que está sendo carregada no frame
        indice = (indice + 1) % fila.length; // move o índice para o próximo frame, voltando ao início se necessário
    }    
}

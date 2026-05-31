package estrategiassubstituicaopaginas;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class SubstituidorPagina {
    private EstrategiaSubstituicaoPagina estrategia;

    public SubstituidorPagina(EstrategiaSubstituicaoPagina estrategia) {
        this.estrategia = estrategia;
    }

    public void substituirPagina(int pagina, int frame) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia de substituição de página não inicializada");
        }
        estrategia.substituirPagina(pagina, frame);
    }
    
    public void setEstrategia(EstrategiaSubstituicaoPagina estrategia) {
        this.estrategia = estrategia;
    }
}

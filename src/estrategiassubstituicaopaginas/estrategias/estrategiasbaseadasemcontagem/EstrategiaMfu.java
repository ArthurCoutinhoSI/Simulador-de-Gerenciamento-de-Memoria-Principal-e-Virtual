package estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaMfu extends EstrategiasBaseadasEmContagem implements EstrategiaSubstituicaoPagina{
    
    public EstrategiaMfu(){
        super();
    }

    @Override
    protected void incrementaOuDecrementaPorFrameNaLista(int frame){
        for (FrameComContadorDeAcesso frameComContadorDeAcesso : lista) {
            if (frameComContadorDeAcesso.getFrame() == frame) {
                frameComContadorDeAcesso.decrementaAcesso();
            }            
        }
    }
}

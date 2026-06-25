package estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaMfu extends EstrategiasBaseadasEmContagem implements EstrategiaSubstituicaoPagina{
    String nome;

    public EstrategiaMfu(){
        super();
        nome = "MFU";
    }

    @Override
    protected void incrementaOuDecrementaPorFrameNaLista(int frame){
        for (FrameComContadorDeAcesso frameComContadorDeAcesso : lista) {
            if (frameComContadorDeAcesso.getFrame() == frame) {
                frameComContadorDeAcesso.decrementaAcesso();
            }            
        }
    }

    public String getNome() {
        return nome;
    }
}

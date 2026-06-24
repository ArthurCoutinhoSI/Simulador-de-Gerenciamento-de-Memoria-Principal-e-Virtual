package estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaLfu extends EstrategiasBaseadasEmContagem implements EstrategiaSubstituicaoPagina{
    String nome;

    public EstrategiaLfu(){
        super();
        nome = "LFU";
    }

    @Override
    protected void incrementaOuDecrementaPorFrameNaLista(int frame){
        for (FrameComContadorDeAcesso frameComContadorDeAcesso : lista) {
            if (frameComContadorDeAcesso.getFrame() == frame) {
                frameComContadorDeAcesso.incrementaAcesso();
            }else{
                if(frameComContadorDeAcesso.getAcessos() > 0) {
                    frameComContadorDeAcesso.decrementaAcesso();
                }
            }
        }
    }

    public String getNome() {
        return nome;
    }
}

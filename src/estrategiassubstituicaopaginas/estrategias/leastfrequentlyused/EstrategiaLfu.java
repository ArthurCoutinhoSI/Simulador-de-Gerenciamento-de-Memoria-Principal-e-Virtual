package estrategiassubstituicaopaginas.estrategias.leastfrequentlyused;

import java.util.ArrayList;
import java.util.Comparator;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaLfu implements EstrategiaSubstituicaoPagina{
    ArrayList<FrameComContadorDeAcesso> lista;

    public EstrategiaLfu(){
        this.lista = new ArrayList<>();
    }

    public void add(int frame){
        FrameComContadorDeAcesso novoFrame = new FrameComContadorDeAcesso(frame);
        lista.addLast(novoFrame);
        lista.sort(Comparator.comparingInt(FrameComContadorDeAcesso::getAcessos));
    }

    public int remove(){
        return lista.removeFirst().getFrame();
    }

    public void acessa(int frame){
        this.incrementaPorFrameNaLista(frame);
        lista.sort(Comparator.comparingInt(FrameComContadorDeAcesso::getAcessos));
    }

    private void incrementaPorFrameNaLista(int frame){
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
}

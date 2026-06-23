package estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class EstrategiasBaseadasEmContagem {
    ArrayList<FrameComContadorDeAcesso> lista;

    protected EstrategiasBaseadasEmContagem(){
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
        this.incrementaOuDecrementaPorFrameNaLista(frame);
        lista.sort(Comparator.comparingInt(FrameComContadorDeAcesso::getAcessos));
    }

    protected abstract void incrementaOuDecrementaPorFrameNaLista(int frame);
}

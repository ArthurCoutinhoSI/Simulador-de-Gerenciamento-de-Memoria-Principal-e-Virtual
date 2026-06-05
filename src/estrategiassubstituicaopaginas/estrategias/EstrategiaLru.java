package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaLru implements EstrategiaSubstituicaoPagina{
    ArrayList<Integer> lista;

    public EstrategiaLru(){
        this.lista = new ArrayList<>();
    }

    public void add(int frame){
        lista.addLast(frame);
    }

    public int remove(){
        return lista.removeFirst();
    }

    public void acessa(int frame){
        lista.remove(frame);
        lista.addLast(frame);
    }
}

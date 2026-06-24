package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaLru implements EstrategiaSubstituicaoPagina{
    ArrayList<Integer> lista;
    String nome;

    public EstrategiaLru(){
        this.lista = new ArrayList<>();
        nome = "LRU";
    }

    public void add(int frame){
        lista.addLast(frame);
    }

    public int remove(){
        return lista.removeFirst();
    }

    public void acessa(int frame){
        lista.remove(Integer.valueOf(frame));
        lista.addLast(frame);
    }

    public String getNome() {
        return nome;
    }
}

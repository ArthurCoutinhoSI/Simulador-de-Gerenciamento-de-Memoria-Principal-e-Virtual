package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    ArrayList<Integer> fila;

	public EstrategiaFifo(){
		fila = new ArrayList<>();
	}
	
	public void add(int frame){
		fila.add(frame);
	}

	public int remove(){
		return fila.remove(0);
	}
}

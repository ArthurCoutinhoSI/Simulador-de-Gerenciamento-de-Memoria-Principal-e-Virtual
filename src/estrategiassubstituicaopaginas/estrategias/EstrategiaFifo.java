package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    ArrayList<Integer> fila;

	public EstrategiaFifo(){
		fila = new ArrayList<>();
	}
	
	public void add(int frame){
		fila.addLast(frame);
	}

	public int remove(){
	if(fila.isEmpty()) { // isso aqui nem é pra acontecer
			return -1;
		}
		return fila.removeFirst();
	}
}

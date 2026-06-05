package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import pagetable.PageTable;
import pagetable.PageTableObject;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    ArrayList<int> fila;

	public EstrategiaFifo(){
		fila = new ArrayList<>();
	}
	
}

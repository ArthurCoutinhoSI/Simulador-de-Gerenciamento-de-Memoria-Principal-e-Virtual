package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import pagetable.PageTable;
import pagetable.PageTableObject;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    ArrayList<PageTable> fila;

	public EstrategiaFifo(){
		fila = new ArrayList<>();
	}

	public void acessarAdicionarOuSubstituirPagina(PageTable pageTable, int paginaIndex) throws Exception{
        if (pageTable == null || paginaIndex < 0) {
            throw new Exception("pageTable == null || paginaIndex < 0");
        }

        if (this.fila.contains(paginaIndex)) {
            // não faz nada
			return;
        }

		//  getframelivre
		int frame = -1;
		PageTableObject aux = new PageTableObject(frame, true);

		if(pageTable.size() == pageTable.getCapacidade()){
			fila.add(frame);
			pageTable.put(paginaIndex, aux);
			return;
		}

		pageTable.remove(fila.remove(0).);
		fila.add(frame);

		return;
	}
}

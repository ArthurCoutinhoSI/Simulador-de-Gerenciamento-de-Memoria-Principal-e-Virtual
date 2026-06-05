package estrategiassubstituicaopaginas.interfaces;

import pagetable.PageTable;

public interface EstrategiaSubstituicaoPagina {
    public void acessarAdicionarOuSubstituirPagina(PageTable pageTable, int frame) throws Exception;
}

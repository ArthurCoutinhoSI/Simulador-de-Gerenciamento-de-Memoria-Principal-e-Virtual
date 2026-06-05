package estrategiassubstituicaopaginas.interfaces;

import pagetable.PageTable;

public interface EstrategiaSubstituicaoPagina {
    public void add(int frame);
    public int remove();
    public void acessa(int frame);
}

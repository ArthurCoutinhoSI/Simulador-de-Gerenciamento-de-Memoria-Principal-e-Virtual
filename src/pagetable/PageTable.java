package pagetable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PageTable {
	// Implementado como um mapa de número de página virtual -> PageTableObject
	private final Map<Integer, PageTableObject> pageTable;
	private final int capacidade;

	public PageTable(int capacidade) {
		this.pageTable = HashMap.newHashMap(capacidade);
		this.capacidade = capacidade;
	}

	public void put(int virtualPageNumber, PageTableObject obj) {
		pageTable.put(virtualPageNumber, obj);
	}

	public PageTableObject get(int virtualPageNumber) {
		return pageTable.get(virtualPageNumber);
	}

	public boolean contains(int virtualPageNumber) {
		return pageTable.containsKey(virtualPageNumber);
	}

	// faz o softdelete.
	public PageTableObject removeByframe(PageTableObject ) {
		PageTableObject pto = pageTable.containsValue();
		pto.setEstaPresente(false);
		return pto;
	}

	public int size() {
		return pageTable.size();
	}

	public int getCapacidade(){
		return this.capacidade;
	}
}

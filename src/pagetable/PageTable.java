package pagetable;

import java.util.HashMap;
import java.util.Map;

// basicamente uma tabela hash
public class PageTable {
	// implementado como um mapa de número de página virtual -> PageTableObjec
	private final Map<Integer, PageTableObject> pageTable;

	public PageTable(int initialCapacity) {
		this.pageTable = HashMap.newHashMap(initialCapacity);
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

	public PageTableObject remove(int virtualPageNumber) {
		return pageTable.remove(virtualPageNumber);
	}

	public int size() {
		return pageTable.size();
	}
}

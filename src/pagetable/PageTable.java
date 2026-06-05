package pagetable;

public class PageTable {
	// tabela hash do diretorio
	PageTableObject[] pageTable;
	int capacidade;

	public PageTable(int n){
		this.pageTable = new PageTableObject[n];
		this.capacidade = n;
	}

	public void add(int index, int frame){
		pageTable[index].setFrame(frame);
		pageTable[index].setEstaPresente(true);
	}

	public int softRemove(int index){
		pageTable[index].setEstaPresente(false);
		return pageTable[index].getFrame();
	}

	public int findIndexOfFrame(int frame) {
		for (int i = 0; i < pageTable.length; i++) {
			if(pageTable[i].getFrame() == frame){
				return i;
			}
		}
		return -1;
	}
}

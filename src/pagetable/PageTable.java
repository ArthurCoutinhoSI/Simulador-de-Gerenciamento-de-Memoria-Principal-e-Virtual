package pagetable;

public class PageTable {
	// tabela hash do diretorio
	PageTableObject[] pageTable;

	public PageTable(int n){
		this.pageTable = new PageTableObject[n];
	}

	public boolean add(int index, int frame){
		if(index > pageTable.length - 1 || index < 0){
			return false;
		}

		pageTable[index].setFrame(frame);
		pageTable[index].setEstaPresente(true);
		
		return true;
	}

	public int softRemove(int index){
		if(index > pageTable.length - 1 || index < 0){
			return -1;
		}

		pageTable[index].setEstaPresente(false);
		return pageTable[index].getFrame();
	}

	public int findIndexOfFrame(int frame) {
		for (int i = 0; i < pageTable.length; i++) {
			if(pageTable[i].getFrame() == frame && pageTable[i].getEstaPresente()){
				return i;
			}
		}
		return -1;
	}
}

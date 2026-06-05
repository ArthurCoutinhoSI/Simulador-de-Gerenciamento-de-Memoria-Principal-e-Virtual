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

	public int softRemoveByFrame(int frame){

		int index = findIndexOfFrame(frame);

		pageTable[index].setEstaPresente(false);
		return index;
	}

	public int findIndexOfFrame(int frame) {
		for (int i = 0; i < pageTable.length; i++) {
			if(pageTable[i].getFrame() == frame && pageTable[i].getEstaPresente()){
				return i;
			}
		}
		return -1;
	}

	public int getFrameByIndex(int index){
		return pageTable[index].getFrame();
	}

	public String toString(){
		return "";
	}
}

package pagetable;

import diretorio.DiretorioService;

public class PageTable {
	// tabela hash do diretorio
	PageTableObject[] pageTableObjects;

	public PageTable(int n){
		this.pageTableObjects = new PageTableObject[n];
		this.instanciaPageTableObjects(); // isso é necessário pra não ficar um vetor de nulls, já que é um vetor de objetos
	}

	private void instanciaPageTableObjects(){
		for (int i = 0; i < pageTableObjects.length; i++) {
			this.pageTableObjects[i] = new PageTableObject();
		}
	}

	public boolean add(int index, int frame){
		if(index > pageTableObjects.length - 1 || index < 0){
			return false;
		}

		pageTableObjects[index].setFrame(frame);
		pageTableObjects[index].setEstaPresente(true);
		
		return true;
	}

	public int softRemoveByFrame(int frame){

		int index = findIndexOfFrame(frame);

		pageTableObjects[index].setEstaPresente(false);
		return index;
	}

	public int findIndexOfFrame(int frame) {
		for (int i = 0; i < pageTableObjects.length; i++) {
			if(pageTableObjects[i].getFrame() == frame && pageTableObjects[i].getEstaPresente()){
				return i;
			}
		}
		return -1;
	}

	public int getFrameByIndex(int index){
		if (pageTableObjects[index].getEstaPresente()) {
			return pageTableObjects[index].getFrame();
		}
		return -1;
	}
}

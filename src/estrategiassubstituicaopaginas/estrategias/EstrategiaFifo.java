package estrategiassubstituicaopaginas.estrategias;

import java.util.ArrayList;

import estrategiassubstituicaopaginas.interfaces.EstrategiaSubstituicaoPagina;
import pagetable.PageTableObject;

public class EstrategiaFifo implements EstrategiaSubstituicaoPagina {
    
    PageTableObject pageTable[];
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public EstrategiaFifo(PageTableObject[] pageTable, int capacidade){
        this.pageTable = pageTable;
        this.capacidade = capacidade;
        this.inicio = 0;
        this.fim = 0;
        this.tamanho = pageTable.length;
    }    

    // nesse caso, a o metodo substitui ou adiciona a pagina no frame livre, e retorna a pagina que foi substituida, caso haja necessidade de substituição
    @Override
    public int adicionarPagina(int frame) {
        return enfileirar(frame);
    }

    private int enfileirar(int frame){
        int substituido = -1;
        if (estaCheia()) {
            substituido = desenfileirar();
        }
        pageTable[fim].setFrame(frame);
        fim = (fim + 1) % capacidade; // Lógica circular
        tamanho++;

        return substituido;
    }

    private int desenfileirar() {
        int valorRemovido = pageTable[inicio].getFrame();
        inicio = (inicio + 1) % capacidade; // Lógica circular
        tamanho--;
        return valorRemovido;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }
}

package memoriaprincipal;

import diretorio.DiretorioService;

public class MemoriaPrincipal {
    private char[][] memoria;

    public MemoriaPrincipal(int qtdFrames){
        this.memoria = new char[qtdFrames][10];
    }

    public char[][] getMemoriaPrincipal(){
        return this.memoria;
    }

    public int getIndexOfFrameLivre(){
        for (int i = 0; i < memoria.length; i++) {
            if(this.memoria[i][0] == '\u0000') {
                return i;
            }
        }
        return -1;// memoria principal cheia
    }

    public void inserePaginaNaMemoria(int paginaRequerida, int indexDoFrameLivre){
        String conteudo = DiretorioService.buscarConteudoPaginaNoDiretorio(paginaRequerida);
        
        memoria[indexDoFrameLivre] = conteudo.toCharArray();
    }

    public boolean removePaginaDaMemoriaPorFrame(int frame){
        if(frame > this.memoria.length - 1 && frame > 0)
            return false;
        this.memoria[frame][0] = '\u0000'; // nota que a verificação da pagina vazia acontece apenas pelo primeiro caractere realmente
        return true;
    }
}

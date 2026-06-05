package memoriaprincipal;

import diretorio.DiretorioService;

public class MemoriaPrincipal {
    private char[][] memoriaPrincipal;

    public MemoriaPrincipal(int qtdFrames){
        this.memoriaPrincipal = new char[qtdFrames][10];
    }

    public char[][] getMemoriaPrincipal(){
        return this.memoriaPrincipal;
    }

    public int getIndexOfFrameLivre(){
        for (int i = 0; i < memoriaPrincipal.length; i++) {
            if(this.memoriaPrincipal[i][0] == '\u0000') {
                return i;
            }
        }
        return -1;// memoria principal cheia
    }

    public void inserePaginaNaMemoria(int paginaRequerida, int indexOfFrameLivre){
        char[] conteudo = DiretorioService.buscarConteudoPaginaNoDiretorio(paginaRequerida);
        
        memoriaPrincipal[indexOfFrameLivre] = conteudo;
    }

    public boolean removePaginaDaMemoriaPorframe(int frame){
        if(frame > memoriaPrincipal.length - 1 && frame > 0)
            return false;
        memoriaPrincipal[frame][0] = '\u0000'; // nota que a verificação da pagina vazia acontece apenas pelo primeiro caractere realmente
        return true;
    }
}

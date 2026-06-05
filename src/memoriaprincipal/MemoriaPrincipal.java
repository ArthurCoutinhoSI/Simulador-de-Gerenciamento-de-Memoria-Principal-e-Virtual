package memoriaprincipal;

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
}

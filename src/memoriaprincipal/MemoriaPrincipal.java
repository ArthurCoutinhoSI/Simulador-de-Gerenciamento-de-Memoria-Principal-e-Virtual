package memoriaprincipal;

public class MemoriaPrincipal {
    private char[][] frames;

    public MemoriaPrincipal(int quantidadeFrames) {
        this.frames = new char[quantidadeFrames][10]; // cada página tem 10 caracteres
    }

    public char[][] getFrames() {
        return frames;
    }

    public void setFrame(int index, char[] frame) {
        this.frames[index] = frame;
    }
}

package pagetable;

public class PageTable {
    private int[] frames;
    private boolean[] estaPresente;

    public PageTable(int n) {
        this.frames = new int[n];
        this.estaPresente = new boolean[n];
    }

    public int getFrame(int index) {
        return frames[index];
    }

    public int[] getFrames() {
        return frames;
    }

    public boolean estaPresente(int index) {
        return estaPresente[index];
    }

    public void setFrame(int index, int frame) {
        this.frames[index] = frame;
    }

    public void setPresente(int index, boolean presente) {
        this.estaPresente[index] = presente;
    }
}

package pagetable;

public class PageTableObject {
    private int frame;
    private boolean estaPresente;

    public PageTableObject() {
        this.frame = 0;
        this.estaPresente = false;
    }

    public int getFrames() {
        return frame;
    }

    public boolean getEstaPresente() {
        return estaPresente;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setPresente(boolean presente) {
        this.estaPresente = presente;
    }
}

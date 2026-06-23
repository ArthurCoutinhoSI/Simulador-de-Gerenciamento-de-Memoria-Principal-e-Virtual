package pagetable;

public class PageTableObject {
    private int frame;
    private boolean estaPresente;

    public PageTableObject() {
        this.frame = 0;
        this.estaPresente = false;
    }

    public PageTableObject(int frame, boolean estaPresente){
        this.frame = frame;
        this.estaPresente = estaPresente;
    }

    public int getFrame() {
        return frame;
    }

    public boolean getEstaPresente() {
        return estaPresente;
    }

    public void setFrame(int frame) {
        this.frame = frame;
    }

    public void setEstaPresente(boolean presente) {
        this.estaPresente = presente;
    }
}

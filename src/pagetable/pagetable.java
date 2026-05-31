package pagetable;

public class pagetable {
    private char frame;
    private boolean presente;

    public pagetable(char frame, boolean presente) {
        this.frame = frame;
        this.presente = presente;
    }

    public char getFrame() {
        return frame;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setFrame(char frame) {
        this.frame = frame;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}

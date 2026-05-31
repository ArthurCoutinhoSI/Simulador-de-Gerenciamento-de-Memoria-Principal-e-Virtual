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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemoriaPrincipal:\n");
        for (int i = 0; i < frames.length; i++) {
            sb.append("Frame ").append(i).append(": ");
            char[] f = frames[i];
            if (f == null) {
                sb.append("null");
            } else {
                for (char c : f) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    
}

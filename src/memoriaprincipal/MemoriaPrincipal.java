package memoriaprincipal;

import java.nio.file.Path;

import diretorio.DiretorioService;

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

    public boolean temFrameLivre() {
        for (char[] frame : frames) {
            if (frame == null) {
                return true;
            }
        }
        return false;
    }

    public int getFrameLivre() {
        for (int i = 0; i < frames.length; i++) {
            if (frames[i] == null) {
                return i;
            }
        }
        return -1; // Nenhum frame livre encontrado
    }

    public void carregarPagina(int pagina, int frame, Path diretorio) {
        // Simula o carregamento da página no frame, preenchendo com caracteres representativos
        char[] conteudoPagina = DiretorioService.buscarPaginaNoDiretorio(diretorio, pagina);
        for (int i = 0; i < conteudoPagina.length; i++) {
            conteudoPagina[i] = (char) ('A' + (pagina % 26)); // Exemplo de conteúdo da página
        }
        setFrame(frame, conteudoPagina);
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

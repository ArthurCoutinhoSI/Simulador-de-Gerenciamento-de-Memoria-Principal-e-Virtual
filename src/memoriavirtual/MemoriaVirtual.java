package memoriavirtual;

public class MemoriaVirtual {
    private char[][] paginas;

    public MemoriaVirtual(int quantidadePaginas) {
        this.paginas = new char[quantidadePaginas][10]; // cada página tem 10 caracteres
    }

    public char[][] getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MemoriaVirtual:\n");
        for (int i = 0; i < paginas.length; i++) {
            sb.append("Página ").append(i).append(": ");
            char[] p = paginas[i];
            if (p == null) {
                sb.append("null");
            } else {
                for (char c : p) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

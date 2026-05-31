package memoriavirtual;

public class MemoriaVirtual {
    private char[][] paginas;

    public MemoriaVirtual(int quantidadePaginas) {
        this.paginas = new char[quantidadePaginas][10]; // cada página tem 10 caracteres
    }

    public char[][] getPaginas() {
        return paginas;
    }
}

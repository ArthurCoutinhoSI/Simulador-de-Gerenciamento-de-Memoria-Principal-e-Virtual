package pagesimulator;

import gerenciadormemoria.GerenciadorMemoria;

public class PageSimulator {
    public static void main(String[] args) {
        String diretorio = args[0];
        String estrategia = args[1];
        int quantidadeFramesMemoria = Integer.parseInt(args[2]);
        int quantidadePaginasUnicas = Integer.parseInt(args[3]);
        int quantidadePaginasRequeridas = Integer.parseInt(args[4]);

        GerenciadorMemoria simulador = new GerenciadorMemoria(estrategia, quantidadeFramesMemoria, quantidadePaginasUnicas, diretorio);

        simulador.executarSimulacao(quantidadePaginasRequeridas);
    }
}

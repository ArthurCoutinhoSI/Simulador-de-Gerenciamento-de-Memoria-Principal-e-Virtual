package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import gerenciadormemoria.GerenciadorMemoria;
import relatorio.Relatorio;

public class main {
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

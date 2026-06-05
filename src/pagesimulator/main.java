package pagesimulator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

import diretorio.DiretorioService;
import estrategiassubstituicaopaginas.GerenciadorMemoria;
import estrategiassubstituicaopaginas.estrategias.EstrategiaFifo;
import relatorio.Relatorio;

public class main {
    public static void main(String[] args) {
        Path diretorio = Paths.get(args[0]);
        String estrategia = args[1];
        int quantidadeFramesMemoria = Integer.parseInt(args[2]);
        int quantidadePaginasUnicas = Integer.parseInt(args[3]);
        int quantidadePaginasRequeridas = Integer.parseInt(args[4]);

        GerenciadorMemoria simulador = new GerenciadorMemoria(estrategia, quantidadeFramesMemoria, quantidadePaginasUnicas, estrategia)    

        simulador.executarSimulacao();
    }
}

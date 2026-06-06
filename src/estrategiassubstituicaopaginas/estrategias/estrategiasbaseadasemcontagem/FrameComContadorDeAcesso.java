package estrategiassubstituicaopaginas.estrategias.estrategiasbaseadasemcontagem;

public class FrameComContadorDeAcesso {
    private int frame;
    private int acessos;

    public FrameComContadorDeAcesso(int frame){
        this.frame = frame;
        this.acessos = 0;
    }

    public int incrementaAcesso(){
        return this.acessos += 1;
    }

    public int decrementaAcesso(){
        return this.acessos -= 1;
    }

    public int getFrame(){
        return this.frame;
    }

    public int getAcessos(){
        return this.acessos;
    }
}

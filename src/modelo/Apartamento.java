package modelo;

public class Apartamento extends Financiamento{

    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragem,
                       int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroAndar = numeroAndar;
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

}

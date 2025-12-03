package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento{

    private double areaContruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida,
                double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaContruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        return super.calcularPagamentoMensal() + 80;
    }
}

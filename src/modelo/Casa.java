package modelo;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private double areaContruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida,
                double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaContruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {

        double parcelaBase = super.calcularPagamentoMensal();


        double taxaMensal = getTaxaJurosAnual() / 12;
        double valorJurosMensal = getValorImovel() * taxaMensal;


        if (80 > (valorJurosMensal / 2)) {
            throw new AumentoMaiorDoQueJurosException("O acréscimo de R$80 é maior que a metade dos juros!");
        }


        return parcelaBase + 80;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(";%.2f;%.2f", this.areaContruida, this.areaTerreno);
    }
}
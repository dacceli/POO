package modelo;

public class Terreno extends Financiamento{

    private String tipoDeZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoDeZona){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() * 1.2;
    }

    @Override
    public String toString() {
        return super.toString() + this.tipoDeZona;
    }
}

package modelo;
import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorImovel = valorImovel;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));

    }

    public double pagamentoTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void dadosFinanciamento(){
        System.out.println("Os dados do seu financiamento são:");
        System.out.println("Prazo do financiamento: " + this.prazoFinanciamento + "\nValor do imóvel: " + this.valorImovel + "\nValor do financiamento" + pagamentoTotal());
    }

    public String toString() {
        return String.format("%.2f;%d;%.2f", this.valorImovel, this.prazoFinanciamento, this.taxaJurosAnual);

    }
}
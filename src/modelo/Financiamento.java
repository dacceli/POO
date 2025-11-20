package modelo;

public abstract class Financiamento{
    private final double valorImovel;
    private final int prazoFinanciamento;
    private final double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
        this.valorImovel = valorImovel;
    }

    public double getValorImovel(){
        return valorImovel;
    }
    public int getPrazoFinanciamento(){
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual(){
        return taxaJurosAnual;
    }

    public double calcularPagamentoMensal(){
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 +(this.taxaJurosAnual / 12));

    }
    public double pagamentoTotal(){
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
    public void dadosDoFinanciamento() {
        System.out.println("Os dados do seu financiamento são os seguintes:");
        System.out.printf("Valor do imóvel: %.2f\nValor Total: %.2f\n", getValorImovel(), this.pagamentoTotal());
    }
}